package esgi.kata.videostore;

public class Movie {
	private String title;
	private int priceCode;

	public MoviePriceCode moviePriceCode;

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;

		setMoviePriceCodeByPriceCode(priceCode);
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int code) {
		priceCode = code;
	}

	public String getTitle() {
		return title;
	}

	public MoviePriceCode getMoviePriceCode() {
		return moviePriceCode;
	}

	private void setMoviePriceCodeByPriceCode(int priceCode) {
		switch (priceCode) {
			case 2:
				this.moviePriceCode = MoviePriceCode.CHILDRENS;
				break;
			case 0:
				this.moviePriceCode = MoviePriceCode.REGULAR;
				break;
			case 1:
				this.moviePriceCode = MoviePriceCode.NEW_RELEASE;
				break;
			default:
				break;
		}
	}
}