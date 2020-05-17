package hello.world;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/consumes")
public class ConsumesController {

    @Post
    public HttpResponse index() {
        return HttpResponse.ok().body("{\"msg\":\"たたけたよ！\"}");
    }
}