package hello.world;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller("/people")
public class PersonController {

    // 事前準備
    Person person = new Person("murakami", 21);
    List<Person> personList = new ArrayList<Person>() {
        {
            add(person);
        }
    };

    // リストを返す
    @Get("/getPerson")
    public HttpResponse<List<Person>> get() {
        return HttpResponse.created(personList);
    }

    // 保存する
    @Post("/saveReactive")
    public Single<HttpResponse<Person>> save(@Body Single<Person> person) {
        return person.map(p -> {
                    personList.add(p);
                    return HttpResponse.created(p);
                }
        );
    }

    // パスパラメータで取得
    @Get("/getPerson/{index}")
    public HttpResponse<Person> get(@PathVariable int index) {
        return HttpResponse.created(personList.get(index));
    }
}