package com.matrix.mym.controller.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.matrix.mym.model.Quiz;

public class QuizDB {
	public static final String TABLE_NAME = "quiz";
	public static final String COL_ID = "_id";
	public static final String COL_QUESTION = "question";
	public static final String COL_OPTION1 = "option1";
	public static final String COL_OPTION2 = "option2";
	public static final String COL_OPTION3 = "option3";
	public static final String COL_OPTION4 = "option4";
	public static final String COL_ANSWER = "answer";
	public static final String COL_TYPE = "type";

	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY NOT NULL, "
			+ COL_QUESTION + " VARCHAR(255) NOT NULL, " + COL_OPTION1
			+ " VARCHAR(50), " + COL_OPTION2 + " VARCHAR(50), " + COL_OPTION3
			+ " VARCHAR(50), " + COL_OPTION4 + " VARCHAR(50), " + COL_ANSWER
			+ " INTEGER NOT NULL, " + COL_TYPE + " INTEGER NOT NULL " + ");";

	public static Quiz getQuiz(long id) {
		Quiz quiz = null;
		try {
			Cursor cursor = MymDataBase.getDb().query(
					TABLE_NAME,
					new String[] { COL_ID, COL_QUESTION, COL_OPTION1,
							COL_OPTION2, COL_OPTION3, COL_OPTION4, COL_ANSWER,
							COL_TYPE }, COL_ID + "=? ",
					new String[] { id + "" }, null, null, null);
			if (cursor.moveToNext()) {
				String question = cursor.getString(cursor
						.getColumnIndex(COL_QUESTION));
				ArrayList<String> options = new ArrayList<String>();
				options.add(cursor.getString(cursor.getColumnIndex(COL_OPTION1)));
				options.add(cursor.getString(cursor.getColumnIndex(COL_OPTION2)));
				options.add(cursor.getString(cursor.getColumnIndex(COL_OPTION3)));
				options.add(cursor.getString(cursor.getColumnIndex(COL_OPTION4)));
				int answer = cursor.getInt(cursor.getColumnIndex(COL_ANSWER));
				int type = cursor.getInt(cursor.getColumnIndex(COL_TYPE));
				quiz = new Quiz(id, question, options, answer, type);
			}
			cursor.close();
		} catch (IllegalStateException ex) {
		}
		return quiz;
	}

	public static void setUpTable(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        inserQuiz(
                db,
                0,
                "Which are the two stock exchanges where most of the trading in US stock market takes place?",
                "NYSE and DOW", "NASDAQ and S&P", "CBO and Euronext", "NYSE and NASDAQ", 3,
                Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                1,
                "Which statutory body is responsible for the overall supervision of the stock market?",
                "Federal Reserve", "IRS", "SEC", "US Government", 2, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,

                2, "Where is the New York Stock Exchange located?",
                "5th Ave", "Wall Street", "Madison Ave",
                "Marine Drive", 1, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                3,
                "Which term most accurately describes selling shares at a higher price than the price at which they were bought?",
                "Loss", "Asset", "Dividend", "Profit", 3, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                4,
                "Which term is used to describe a payout made to shareholders representing their share of a corporation’s profit?",
                "Jackpot", "Coupon", "Dividend", "Asset", 2,
                Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                5,
                "Dematerialisation is the process of :",
                "Converting physical shares into electronic shares",
                "Selling electronic shares",
                "Converting electronic shares into physical shares",
                "Transferring electronic shares from one account to another account",
                0, Quiz.TYPE_4_OPTIONS);
        inserQuiz(db, 6,
                "The depository account that an investor opens is called as:",
                "Broker account", "Intermediary account",
                "Beneficiary account", "Clearing member account", 2,
                Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                7,
                "Which of the following documents is not a valid proof of address (POA) for opening account?",
                "Pan Card", "Passport", "Voter Identity Card", "Bank Passbook",
                0, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                8,
                "Which of the following places does not have a stock exchange?",
                "Canada", "Mexico", "Texas", "United States", 2,
                Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                9,
                "\"Shareholder wealth\" in a firm is represented by:",
                "The number of people employed in the firm",
                "The book value of the firm's assets less the book value of its liabilities",
                "The amount of salary paid to its employees",
                "The market price per share of the firm's common stock", 3,
                Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                10,
                "If you are bullish about a stock, you would do which of the following call options on the stock?",
                "Sell", "Buy", "Short", "Write", 1, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                11,
                "If you are bearish about a stock, you would do which of the following put options on the stock?",
                "Sell", "Buy", "Short", "Write", 0, Quiz.TYPE_4_OPTIONS);
        inserQuiz(db, 12,
                "The operations of private mutual funds are regulated by?",
                "SEC", "Ministry of Finance", "NASDQ", "SEC", 0,
                Quiz.TYPE_4_OPTIONS);
        inserQuiz(db, 13,
                "The registered owner of securities held in demat form is?",
                "The Depository participant", "The Depository", "SEBI",
                "The R&T Agent", 1, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                14,
                "NYSE, the capital market regulator is",
                "A division of the Ministry of Finance",
                "A self-regulatory body like FINRA, CBO,stock exchanges etc. To police the capital market",
                "An autonomous body set-up under an act of the US Government",
                "Set up by the Government of Mexico to meet the requirements of the SEC",
                2, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                15, "ISIN stands for ______",
                "International Securities Identification number",
                "International Securities Identity number",
                "Island Securities Identity number",
                "Indi Ari Securities Identification number", 0,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                16,
                "Can shares that are not registered in the name of the account holder be dematerialized?",
                "Yes, at the discretion of the Issuer/ its R and T Agent",
                "No, shares have to be registered in the name of the concerned investor",
                "Yes, at the discretion of the DP",
                "Yes, provided a duly filled transfer deed is attached", 1,
                Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                17, "A mutual fund is a collection of?",
                "Stocks and cash", "Stocks, bonds ,and other securities",
                "Bonds", "Interests accrued on a stock", 1, Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                18,
                "The capital a company raises by selling shares is referred to as a?",
                "Bond", "Mutual fund", "Capital gain", "Stock", 3,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                19,
                "Clearing and settlement operations of the NYSE are carried out by?",
                "National Security Depository Ltd.",
                "National Security Clearing Co-operation",
                "State Bank of New York", "By the exchange itself", 1,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                20,
                "The broker shall have to furnish the SEC a copy of audited balance sheet and profit and loss account within ",
                "One month of each accounting period",
                "Two months of each accounting period",
                "Three months of each accounting period",
                "Six months of each accounting period", 3, Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                21,
                "Investment is the ",
                "Net additions made to the nation’s capital stocks",
                "Person’s commitment to buy a flat or a house",
                "Employment of funds on asset to earn returns",
                "Employment of funds on goods and services that are used in production process",
                2, Quiz.TYPE_4_OPTIONS);

        inserQuiz(db, 22, "Allotment of securities should be done within ",
                "60 days", "30 days", "75 days", "90 days", 1,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                23,
                " The American Stock Exchange was recognized on a permanent basis in ",
                "1956", "1921", "1950", "1958", 1, Quiz.TYPE_4_OPTIONS);

        inserQuiz(db, 24, "The NYSE was established in? ", "1792", "1892",
                "1874", "1872", 0, Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                25,
                "The chance of loss or the variability of returns associated with a given asset is? ",
                "Profitability", "Returns", "Value", "Risk", 3,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                26,
                "What is the main purpose of bank account details in account opening form? ",
                "For DP to debit the savings bank account for charges on the services enjoyed",
                "For the purpose of income tax authorities",
                "For safe distribution of cash corporate actions",
                "For NSDL to debit the savings bank account for charges on the services enjoyed",
                2, Quiz.TYPE_4_OPTIONS);
        inserQuiz(
                db,
                27,
                "What happens when you buy a company’s stock? ",
                "You own a part of the company",
                "You have lent money to the company",
                "You are liable for the company’s debts",
                "The company will return your original investment to you with interest",
                0, Quiz.TYPE_4_OPTIONS);

        inserQuiz(db, 28, "What happens when you buy a company’s bond?",
                "You own a part of the company",
                "You have lent money to the company",
                "You are liable for the company’s debts",
                "You can vote on shareholder resolutions", 1,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(db,29,
                        "Which of the following is useful in evaluating credit and collection policies? ",
                        "Average collection period", "Average Sales", "Current ratio",
                        "Average payment period", 0, Quiz.TYPE_4_OPTIONS);

        inserQuiz(db, 30, "Arbitrage is defined as? ",
                "Buying and selling in two markets simultaneously",
                "A rate of interest", "A Fee", "Arbitrage is a dispute", 0,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(db, 31, "DVP, in the capital market context stands for? ",
                "Default versus payment", "Delivery versus payment",
                "Default versus penalty", "Delivery versus penalty", 1,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                32,
                "Mutual funds are regulated in USA by which among the following? ",
                "FINRA", "The FED", "Stock exchanges", "SEC and FINRA", 3,
                Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                33,
                "In which among the following types comes the Interest Rate Risk? ",
                "Credit Risk", "Market Risk", "Operational Risk",
                "All of the Above", 1, Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                34,
                "Warehousing facility means? ",
                "Storing stocks with merchant banker",
                "Storing stocks with broker",
                "Issuing separate contract notes for different trade",
                "Issuing one contract note for a large quantity traded in parts",
                3, Quiz.TYPE_4_OPTIONS);

        inserQuiz(
                db,
                35,
                "The liquidity factor of the stock included in the NYSE Sensex is based on? ",
                "Average deal as a percentage of company shares",
                "The average number of deal of a scrip",
                "Market capitalisation of the stock",
                "Capital stock of the company", 1, Quiz.TYPE_4_OPTIONS);


        inserQuiz(
				db,
				36,
				"What happens when you buy a company’s stock? ",
				"You own a part of the company",
				"You have lent money to the company",
				"You are liable for the company’s debts",
				"The company will return your original investment to you with interest",
				0, Quiz.TYPE_4_OPTIONS);

		inserQuiz(db, 37, "What happens when you buy a company’s bond?",
				"You own a part of the company",
				"You have lent money to the company",
				"You are liable for the company’s debts",
				"You can vote on shareholder resolutions", 1,
				Quiz.TYPE_4_OPTIONS);

		inserQuiz(db, 38, "Index calculation frequency for BSE Sensex is? ",
				"30 minutes lagged", "1 hour lagged", "Real time",
				"2 hour lagged", 2, Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				39,
				"The Bombay Stock Exchange Ltd. (BSE) in 1986 came out with a stock index? ",
				"BANKEX", "BSE-100", "BSE-200", "SENSEX", 3,
				Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				40,
				"Which of the following is useful in evaluating credit and collection policies? ",
				"Average collection period", "Average Sales", "Current ratio",
				"Average payment period", 0, Quiz.TYPE_4_OPTIONS);

		inserQuiz(db, 41, "Arbitrage is defined as? ",
				"Buying and selling in two markets simultaneously",
				"A rate of interest", "A Fee", "Arbitrage is a dispute", 0,
				Quiz.TYPE_4_OPTIONS);

		inserQuiz(db, 42, "DVP, in the capital market context stands for? ",
				"Default versus payment", "Delivery versus payment",
				"Default versus penalty", "Delivery versus penalty", 1,
				Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				43,
				"The new Share Price Index (in dollar value) of Mumbai share market is?",
				"DOLEX", "UREX", "FOREX", "SENSEX", 0, Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				44,
				"Mutual funds are regulated in India by which among the following? ",
				"RBI", "SEBI", "Stock exchanges", "Both RBI and SEBI", 1,
				Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				45,
				"In which among the following types comes the Interest Rate Risk? ",
				"Credit Risk", "Market Risk", "Operational Risk",
				"All of the Above", 1, Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				46,
				"Warehousing facility means? ",
				"Storing stocks with merchant banker",
				"Storing stocks with broker",
				"Issuing separate contract notes for different trade",
				"Issuing one contract note for a large quantity traded in parts",
				3, Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				47,
				"The liquidity factor of the stock included in the BSE Sensex is based on? ",
				"Average deal as a percentage of company shares",
				"The average number of deal of a scrip",
				"Market capitalisation of the stock",
				"Capital stock of the company", 1, Quiz.TYPE_4_OPTIONS);

		inserQuiz(
				db,
				48,
				"Over the Counter Exchange of India was started after the role model of? ",
				"NASAQ", "JASAQ", "NASDAQ and JASDAQ", "NSE", 2,
				Quiz.TYPE_4_OPTIONS);

		inserQuiz(db, 49, "The accounting period cycle of NSE is? ",
				"Wednesday to nest Tuesday", "Tuesday to next Wednesday",
				"Monday to next Friday", "Wednesday to next Wednesday", 0,
				Quiz.TYPE_4_OPTIONS);

	}

	private static void inserQuiz(SQLiteDatabase db, long id, String question,
			String option1, String option2, String option3, String option4,
			int answer, int type) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(COL_ID, id);
		contentValues.put(COL_QUESTION, question);
		contentValues.put(COL_OPTION1, option1);
		contentValues.put(COL_OPTION2, option2);
		contentValues.put(COL_OPTION3, option3);
		contentValues.put(COL_OPTION4, option4);
		contentValues.put(COL_ANSWER, answer);
		contentValues.put(COL_TYPE, type);
		db.insert(TABLE_NAME, COL_ID, contentValues);
	}

}
