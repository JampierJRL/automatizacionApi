package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCreatePost implements Task {

    private final String title;
    private final String body;
    private final String userId;

    public PostCreatePost(String title, String body, String userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public static Performable withDetails(String title, String body, String userId) {
        return instrumented(PostCreatePost.class, title, body, userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/posts")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body("{ \"title\": \"" + title + "\", \"body\": \"" + body + "\", \"userId\": \"" + userId + "\" }")
                                .log().all()
                        )
        );
    }
}