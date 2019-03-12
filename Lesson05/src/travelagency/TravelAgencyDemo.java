package travelagency;

import travelagency.city.domain.City;
import travelagency.city.service.CityMemoryService;
import travelagency.common.solutions.dataclasses.Pair;
import travelagency.country.domain.Country;
import travelagency.country.service.CountryMemoryService;
import travelagency.order.service.OrderMemoryService;
import travelagency.user.domain.User;
import travelagency.user.service.UserMemoryService;

public class TravelAgencyDemo {

    private static class Application {
        private UserMemoryService userService = new UserMemoryService();
        private CountryMemoryService countryService = new CountryMemoryService();
        private CityMemoryService cityService = new CityMemoryService();
        private OrderMemoryService orderService = new OrderMemoryService();

        private void addUsers() {
            String[] usersAsCsv = new String[]{
                    "Ivan  | Ivanov | 23",
                    "Petr | Petrov | 21",
                    "Olga | Ivanova | 27",
                    "Pavel |Pavlov|32",
                    "Nastya |Garmatina|25",
                    "Sasha |Subbotina | 25",
                    "Georgii|Bereza|29",
                    "Viktoria| Mihailova| 27",
                    "Nikolai |Agishev|30"
            };

            Long id = 0L;
            for (String user : usersAsCsv) {
                String[] userAttrs = user.split("\\|");
                int attrIndex = -1;
                userService.addUser(new User(++id,
                        userAttrs[++attrIndex].trim(),
                        userAttrs[++attrIndex].trim(),
                        Integer.parseInt(userAttrs[++attrIndex].trim())));
            }
        }

        private void addCountryWithCities() {
            Pair[] countryWithCities = new Pair[]{
                    new Pair("Russia | Russian",
                            new String[]{
                                    "Moscow | 10000000 | capital" ,
                                    "Saint-Petersburg | 5000000| ",
                                    "Nignii Tagil | 300000| ",
                                    "Smolensk | 350000| "
                            }
                    ),
                    new Pair("Republic of Belarus | Belorussian",
                            new String[]{
                                    "Minsk | 2000000| capital",
                                    "Grodno | 350000| ",
                                    "Vitebsk | 360000| "
                            }
                    ),
                    new Pair("Ukraine| Ukrainian",
                            new String[]{
                                    "Kiev | 3000000| capital",
                                    "Odessa| 1000000 | "
                            }
                    ),
                    new Pair("USA | English",
                            new String[]{
                                    "New York | 8000000 | ",
                                    "Austin | 800000| ",
                                    "Sacramento | 500000| "
                            })

            };

            for (Pair countryCityData : countryWithCities) {
                addCountry(countryCityData.getLeft(), countryCityData.getRight());
            }
        }

        private void addCountry(String countryCsv, String[] cityCsv) {
            String[] attrs = countryCsv.split("\\|");
            int attrIndex = -1;

            Country country = new Country(attrs[++attrIndex].trim(), attrs[++attrIndex].trim());
            country.setCities(new City[cityCsv.length]);

            for (int i = 0; i < cityCsv.length; i++) {
                String csvCity = cityCsv[i];
                attrIndex = -1;
                attrs = csvCity.split("\\|");

                City city = new City();
                city.setName(attrs[++attrIndex].trim());
                city.setPopulation(Integer.parseInt(attrs[++attrIndex].trim()));
                city.setCapital(attrs[++attrIndex].trim().equals("capital"));
                country.getCities()[i] = city;
            }

            countryService.addCountry(country);
        }

        public void fillStorage() {
            addUsers();
            addCountryWithCities();
        }

        public void printUsers() {
            userService.printUsers();
        }

        public void printCountries() {
            countryService.printCountries();
        }

        public void deleteUsers() {
            userService.deleteUser(2L);
            userService.deleteUser(3L);
        }


    }

    public static void main(String[] args) {
        Application application = new Application();
        application.fillStorage();

        application.printUsers();
        application.printCountries();

        application.deleteUsers();
        application.printUsers();

    }
}
