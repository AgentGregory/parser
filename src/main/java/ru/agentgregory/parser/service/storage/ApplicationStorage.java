package ru.agentgregory.parser.service.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.model.Category;
import ru.agentgregory.parser.model.Statistic;
import ru.agentgregory.parser.model.User;
import ru.agentgregory.parser.repository.ArticleRepository;
import ru.agentgregory.parser.repository.CategoryRepository;
import ru.agentgregory.parser.repository.StatisticRepository;
import ru.agentgregory.parser.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationStorage {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final StatisticRepository statisticRepository;

    @Transactional
    public void saveData(List<Article> articles) {
        for (Article article :
                articles) {
            User user = saveUser(article.getUser());
            List<Category> categories = article.getCategories().stream().map(this::saveCategory).collect(Collectors.toList());
            Statistic savedStatistic = statisticRepository.save(article.getStatistic());

            article.setUser(user);
            article.setCategories(categories);
            article.setStatistic(savedStatistic);
            articleRepository.save(article);
        }

    }

    @Transactional
    private Category saveCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findByName(category.getNames());
        return categoryOptional.isEmpty()
                ? categoryRepository.save(category)
                : categoryOptional.get();
    }
@Transactional
    public User saveUser(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        return userOptional.isEmpty()
                ? userRepository.save(user)
                : userOptional.get();
    }
}
