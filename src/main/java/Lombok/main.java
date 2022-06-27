package Lombok;

import Lombok.Geo.Address;
import Lombok.Geo.Company;
import Lombok.Geo.Geo;
import Lombok.Geo.User;
import com.google.gson.Gson;
import org.json.simple.JSONArray;

public class main {
    public static void main(String[] args) {
        User user=new User();
        user.setName("acer");
        user.setAge(10);
        user.setSurname("intel");
        user.setPhoneNumber("123456789");
        Address address=new Address();
        address.setCity("qarshi");
        address.setName("qqwerty");
        Geo geo=new Geo();
        geo.setLang("90");
        geo.setLat("120");
        Company company=new Company();
        company.setName("asdf");
        company.setWebsite("yyyy");
        company.setBio("zzz");
        user.setAddress(address);
        user.setCompany(company);
        address.setGeo(geo);
        System.out.println(user);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(user);
        Gson gson=new Gson();
        String a=gson.toJson(jsonArray);
        System.out.println(a);
    }
}
