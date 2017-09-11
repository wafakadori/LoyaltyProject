package loyalty.service;

import java.io.FileNotFoundException;

public interface LoyaltyService {

	/**
	 * 
	 * @param customerCode
	 * @param cardCode
	 * @return LoyaltyBalanceResponseType
	 * @throws FileNotFoundException 
	 */
	LoyaltyBalanceResponseType getLoyaltyBalance(final String customerCode, final String cardCode) throws FileNotFoundException;

}
