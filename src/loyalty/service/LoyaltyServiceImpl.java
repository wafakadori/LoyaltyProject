/**
 * @author wka
 * I used properties file instead of connection to database just as an example 
 * that could be run without any configuration
 */

package loyalty.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoyaltyServiceImpl implements LoyaltyService {

	private LoyaltyBalanceResponseType result = new LoyaltyBalanceResponseType();

	@Override
	public LoyaltyBalanceResponseType getLoyaltyBalance(String customerCode, String cardCode)
			throws FileNotFoundException {
		try {
			Properties prop = new Properties();
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("customersLoyaltyCards.properties");
			// load properties file
			if(inputStream != null)
			prop.load(inputStream);

			String totalPoint = prop.getProperty(customerCode + "-" + cardCode);

			if (totalPoint != null)
				result.setTotalPoint(Integer.valueOf(totalPoint));
			else
				result.setTotalPoint(null);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
