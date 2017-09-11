package loyalty.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


public class LoyaltyServiceImpl implements LoyaltyService {

	private LoyaltyBalanceResponseType result= new LoyaltyBalanceResponseType();

	@Override
	public LoyaltyBalanceResponseType getLoyaltyBalance(String customerCode, String cardCode)
			throws FileNotFoundException {
		try {
			Properties prop = new Properties();
			FileInputStream inputStream = new FileInputStream("resources/customersLoyaltyCards.properties");
			// load properties file
			prop.load(inputStream);

			String totalPoint = prop.getProperty(customerCode + "-" + cardCode);
			result.setTotalPoint(Integer.valueOf(totalPoint));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
