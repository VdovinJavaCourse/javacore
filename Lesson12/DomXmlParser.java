package Lesson121;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomXmlParser implements XmlParser<List<Country>> {
    @Override
    public List<Country> parse(String file) throws Exception {
        if (!new File(file).exists() || new File(file).isDirectory()) {
            throw new Exception("No such file");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(file));

        Node root = doc.getElementsByTagName("countries").item(0);
        NodeList countries = ((Element) root).getElementsByTagName("country");

        List<Country> parsedCountries = new ArrayList<>();

        if (countries.getLength() > 0) {
            for (int i = 0; i < countries.getLength(); i++) {

                Node xmlCountry = countries.item(i);
                Country country = new Country();
                parsedCountries.add(country);

                NodeList countryInnerTags = xmlCountry.getChildNodes();

                for (int j = 0; j < countryInnerTags.getLength(); j++) {
                    Node countryInner = countryInnerTags.item(j);

                    switch (countryInner.getNodeName()) {
                        case "name": {
                            country.setName(countryInner.getTextContent());
                            break;
                        }

                        case "language": {
                            country.setLanguage(countryInner.getTextContent());
                            break;
                        }

                        case "cities": {
                            country.setCities(new ArrayList<>());

                            NodeList xmlCities = ((Element) countryInner).getElementsByTagName("city");

                            for (int k = 0; k < xmlCities.getLength(); k++) {
                                Element xmlCity = (Element) xmlCities.item(k);
                                if (xmlCity.getAttribute("discriminator").equals(CityDiscriminator.HOT.name())) {
                                    City city = new CityWithHotClimate();
                                    city.discriminator = CityDiscriminator.HOT;
                                    ((CityWithHotClimate) city).setAverageTemperature(Double.parseDouble(xmlCity.getElementsByTagName("averageTemperature").item(0).getTextContent()));
                                    ((CityWithHotClimate) city).setHottestMonth(xmlCity.getElementsByTagName("hottestMonth").item(0).getTextContent());

                                    country.getCities().add(city);
                                }

                                if (xmlCity.getAttribute("discriminator").equals(CityDiscriminator.COLD.name())) {
                                    City city = new CityWithColdClimate();
                                    city.discriminator = CityDiscriminator.COLD;
                                    ((CityWithColdClimate) city).setAverageTemperature(Double.parseDouble(xmlCity.getElementsByTagName("averageTemperature").item(0).getTextContent()));
                                    ((CityWithColdClimate) city).setColdestMonth(xmlCity.getElementsByTagName("coldestMonth").item(0).getTextContent());
                                    ((CityWithColdClimate) city).setPolarLights("yes".equals(xmlCity.getElementsByTagName("polarNights").item(0).getTextContent()));

                                    country.getCities().add(city);
                                }

                                City city = country.getCities().get(country.getCities().size() - 1);
                                city.setName(xmlCity.getElementsByTagName("name").item(0).getTextContent());
                                city.setPopulation(Integer.parseInt(xmlCity.getElementsByTagName("population").item(0).getTextContent()));
                                city.setCapital("Y".equals(xmlCity.getAttribute("isCapital")));


                            }

                            break;
                        }
                    }
                }

            }
        }

        return parsedCountries;
    }

}

