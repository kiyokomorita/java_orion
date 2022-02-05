package dto;

import java.sql.Timestamp;

public class Review {
	//口コミ用の変数宣言
		private Integer reviewCode;

		private Integer reviewApartmentCode;

		private String reviewUserLoginId;

		private String reviewContent;

		private Timestamp reviewAddDate;

		private String reviewName;

		private String reviewFlag;

		private String reviewApartmentName;

		private Integer count;


		//ゲッター・セッター
		public Integer getReviewCode() {
			return reviewCode;
		}

		public void setReviewCode(Integer reviewCode) {
			this.reviewCode = reviewCode;
		}

		public Integer getReviewApartmentCode() {
			return reviewApartmentCode;
		}

		public void setReviewApartmentCode(Integer reviewApartmentCode) {
			this.reviewApartmentCode = reviewApartmentCode;
		}

		public String getReviewUserLoginId() {
			return reviewUserLoginId;
		}

		public void setReviewUserLoginId(String reviewUserLoginId) {
			this.reviewUserLoginId = reviewUserLoginId;
		}

		public String getReviewContent() {
			return reviewContent;
		}

		public void setReviewContent(String reviewContent) {
			this.reviewContent = reviewContent;
		}

		public Timestamp getReviewAddDate() {
			return reviewAddDate;
		}

		public void setReviewAddDate(Timestamp reviewAddDate) {
			this.reviewAddDate = reviewAddDate;
		}

		public String getReviewName() {
			return reviewName;
		}

		public void setReviewName(String reviewName) {
			this.reviewName = reviewName;
		}

		public String getReviewApartmentName() {
			return reviewApartmentName;
		}

		public void setReviewApartmentName(String reapartmentName) {
			this.reviewApartmentName = reapartmentName;
		}

	    public Integer getCount() {
	        return count;
	    }

	    public void setCount(Integer count) {
	        this.count = count;
	    }

	    public String getReviewFlag() {
			return reviewFlag;
		}

		public void setReviewFlag(String reviewFlag) {
			this.reviewFlag = reviewFlag;
		}
}
