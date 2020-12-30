package esgi.kata.videostore;

public abstract class Movie {
	private String title;

	public MoviePriceCode moviePriceCode;

	public Movie(String title) {
		this.title = title;
	}

	// public int getPriceCode() {
	// return priceCode;
	// }

	// public void setPriceCode(int code) {
	// priceCode = code;
	// }

	public String getTitle() {
		return title;
	}

	// public MoviePriceCode getMoviePriceCode() {
	// return moviePriceCode;
	// }

	// private void setMoviePriceCodeByPriceCode(int priceCode) {
	// switch (priceCode) {
	// case 2:
	// this.moviePriceCode = MoviePriceCode.CHILDRENS;
	// break;
	// case 0:
	// this.moviePriceCode = MoviePriceCode.REGULAR;
	// break;
	// case 1:
	// this.moviePriceCode = MoviePriceCode.NEW_RELEASE;
	// break;
	// default:
	// break;
	// }
	// }
}