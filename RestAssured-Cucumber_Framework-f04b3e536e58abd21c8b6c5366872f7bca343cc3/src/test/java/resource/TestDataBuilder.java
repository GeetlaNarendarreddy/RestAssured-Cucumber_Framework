package resource;

import commonUtils.RestFWLogger;
import net.datafaker.Faker;
import pojoPayloads.CreateARepoPojo;

public class TestDataBuilder {
    public static String name;
    public static  String description;
    static CreateARepoPojo createARepoPojo = new CreateARepoPojo();
    Faker faker = new Faker();
    public Object createRepoPayload() {
        createARepoPojo.setName(faker.name().firstName());
        createARepoPojo.setDescription(faker.lorem().sentence());
        return createARepoPojo;

    }
    public Object createRepoPayload(String name,String description) {
        createARepoPojo.setName(name);
        createARepoPojo.setDescription(description);
        return createARepoPojo;

    }


    public static String getRepoName() {

        name = createARepoPojo.getName();
        return name;

    }

    public static String getRepoDescription() {

        description = createARepoPojo.getDescription();
        return description;

    }
}
