package guru.springframework.bootstrap;

import guru.springframework.domain.Author;
import guru.springframework.domain.Product;
import guru.springframework.domain.ProductCategory;
import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.ProductCategoryRepository;
import guru.springframework.repositories.ProductRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by jt on 5/6/16.
 */
@Component
public class DevOpsBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setProductCategoryRepository(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(IteratorUtils.toList(authorRepository.findAll().iterator()).size() == 0) {

            Author jt = new Author();
            jt.setFirstName("Dominik");
            jt.setLastName("Jurasz");
            jt.setId(1);
            jt.setImage("avatar.jpg");

            jt = authorRepository.save(jt);

            ProductCategory instruments = new ProductCategory();
            instruments.setId(1);
            instruments.setCategory("Instruments");
            instruments = productCategoryRepository.save(instruments);

            ProductCategory disks = new ProductCategory();
            disks.setId(2);
            disks.setCategory("Disks");

            disks = productCategoryRepository.save(disks);

            ProductCategory accesories = new ProductCategory();
            accesories.setId(3);
            accesories.setCategory("Accesory");

            accesories = productCategoryRepository.save(accesories);

            ProductCategory speakers = new ProductCategory();
            speakers.setId(4);
            speakers.setCategory("Speakers");

            speakers = productCategoryRepository.save(speakers);

            ProductCategory tickets = new ProductCategory();
            tickets.setId(5);
            tickets.setCategory("Tickets");

            tickets = productCategoryRepository.save(tickets);

            Product stratocaster = new Product();
            stratocaster.setId(1);
            stratocaster.setProductName("Fender Stratocaster HSH");
            stratocaster.setAuthor(jt);
            stratocaster.setProductDescription("The Standard Stratocaster HSH takes the already-blistering Standard Stratocaster HH model and supercharges it even more with the addition of a Standard Stratocaster single-coil pickup between two ferocious Blacktop open-coil humbucking pickups with chrome/black bobbins and a coil-splitting push/pull switch built into the second tone knob that leaves the outside coils active. That means even more sonic versatility in a stylishly distinctive Strat® model for modern guitarists who want heavy and aggressive tone.");

            stratocaster.setPrice(new BigDecimal("3000"));
            stratocaster.setImageUrl("fender.jpg");
            stratocaster.getProductCategories().add(instruments);
            stratocaster.getProductCategories().add(accesories);

            stratocaster = productRepository.save(stratocaster);

            Product telecaster = new Product();
            telecaster.setId(2);
            telecaster.setProductName("Standard Telecaster HH");
            telecaster.setAuthor(jt);
            telecaster.setProductDescription("For modern guitarists who want heavy and aggressive tone from Fender's original workhorse instrument, the Standard Telecaster HH deliver massive high-gain power from two Blacktop open-coil humbucking pickups with chrome/black bobbins and black bezels. Stylish and supercharged, it's built to match the intensity of any playing style, with other distinctive features including a coil-splitting push/pull switch built into the tone knob that leaves the outside coils active. A versatile performer with a full-throated voice.\n" +
                    "\n");
            telecaster.setPrice(new BigDecimal("4500"));
            telecaster.setImageUrl("telecaster.jpg");
            telecaster.getProductCategories().add(instruments);
            telecaster.getProductCategories().add(accesories);

            telecaster = productRepository.save(telecaster);

            Product mustangGt = new Product();
            mustangGt.setId(3);
            mustangGt.setProductName("Mustang GT 40");
            mustangGt.setAuthor(jt);
            mustangGt.setProductDescription("How can a modern legend like the Mustang digital amplifiers be improved? Simple—we do it again, bigger and better with the Mustang GT 40. We take seven decades' worth of experience crafting inspirational tools and use it to add new (and better) amp and effects models while making it easier to use all of this without sacrificing one iota of power. We make it easy to control a studio's worth of authentic amp and effects models with one finger via Bluetooth and the exclusive Fender Tone app.\n" +
                    "\n" +
                    "We invent the world's first WiFi-equipped guitar amplifier, making it easy for you to download the latest updates, access Fender artist-created presets, and connect directly with a community of other creative players and music makers like yourself.\n" +
                    "\n" +
                    "We create the Mustang GT 40 digital amplifier.");
            mustangGt.setPrice(new BigDecimal("700"));
            mustangGt.setImageUrl("mustang.jpg");
            mustangGt.getProductCategories().add(speakers);

            mustangGt = productRepository.save(mustangGt);
        }
    }
}
