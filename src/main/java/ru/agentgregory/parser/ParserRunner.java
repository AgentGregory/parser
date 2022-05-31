package ru.agentgregory.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.model.Category;
import ru.agentgregory.parser.repository.CategoryRepository;
import ru.agentgregory.parser.service.renameNado.CustomTaskExecutor;
import ru.agentgregory.parser.service.loader.Loader;
import ru.agentgregory.parser.service.parser.HtmlParser;
import ru.agentgregory.parser.service.storage.ApplicationStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class ParserRunner implements CommandLineRunner {


    private final CustomTaskExecutor executor;
    private final CategoryRepository categoryRepository;

    private ExecutorService executorService = Executors.newFixedThreadPool(3);


    public static final String HABR_DOMAIN = "https://habr.com";
    private static final String HABR_URL = HABR_DOMAIN + "/ru/all/";

    public static void main(String[] args) {
        SpringApplication.run(ParserRunner.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        List<String> urls = List.of("https://habr.com/ru/all/pm",
                "https://habr.com/ru/all/read",
                "https://habr.com/ru/all/ui");

        List<Callable<List<Article>>> tasks = categoryRepository.findAll().stream()
                .map(category -> (Callable<List<Article>>) () -> executor.execute(category.getUrl()))
                .collect(Collectors.toList());


        List<Article> result = new ArrayList<>();
        for (Future<List<Article>> future : executorService.invokeAll(tasks)) {
            try {
                result.addAll(future.get());
            } catch (ExecutionException e) {
                System.out.println("hui");
            }
        }
        System.out.println("hui");
    }
}
