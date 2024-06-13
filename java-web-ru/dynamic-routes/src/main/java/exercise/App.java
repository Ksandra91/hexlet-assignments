package exercise;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var num = ctx.pathParam("id");
            Map res = new HashMap<>();

//            var res = COMPANIES.stream().flatMap(e -> e.entrySet().stream()).
//                    filter(k -> k.getKey().equals(id)).collect(Collectors.toList());

            for (var e : COMPANIES) {
                if (e.containsKey("id")) {
                    if (e.get("id").equals(num)) {
                        res = e;
                    }
                }
            }

            if (res.isEmpty()) {
                ctx.status(404);
                ctx.result("Company not found");

            } else {
                ctx.json(res);
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });


        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
