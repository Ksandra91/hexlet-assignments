package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(0);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(1);
            int start = (page * per) - per;
            int end = (page * per);

            List<Map<String, String>> result = new ArrayList<>();
            if (page > 0) {
                for (int i = start; i < end; i++) {
                    result.add(USERS.get(i));
                }
            } else {
                if (USERS.size() >= 5) {
                    for (int i = 0; i < 5; i++) {
                        result.add(USERS.get(i));
                    }
                } else {
                    result.addAll(USERS);
                }
            }
            ctx.json(result);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
