import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
    	Restaurant res=null;
    	for(Restaurant r : restaurants) {
    		if(r.getName().equalsIgnoreCase(restaurantName)) {
    			res = r;
    		}
    	}
    	if(res!=null) {
    		return res;
    	}else {
    		throw new restaurantNotFoundException("Restaurant could not be found");
    	}
//    	Optional<Restaurant> restaurantOpt = restaurants.stream().filter(restaurant->restaurantName.equalsIgnoreCase(restaurant.getName())).findFirst();
//        return restaurantOpt.orElseThrow(()-> new restaurantNotFoundException("Restaurant could not be found"));
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
