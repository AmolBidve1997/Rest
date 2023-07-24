package api.payload;

public class Blog {

	private String blogBody;
	private String blogTitle;
	private String blogThumnail;
	private String blogCategory;
	private String blogSubCategory;
	private String status;
	private Object tableContent;
	private String userId;

	public String getBlogBody() {
		return blogBody;
	}

	public void setBlogBody(String blogBody) {
		this.blogBody = blogBody;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogThumnail() {
		return blogThumnail;
	}

	public void setBlogThumnail(String blogThumnail) {
		this.blogThumnail = blogThumnail;
	}

	public String getBlogCategory() {
		return blogCategory;
	}

	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}

	public String getBlogSubCategory() {
		return blogSubCategory;
	}

	public void setBlogSubCategory(String blogSubCategory) {
		this.blogSubCategory = blogSubCategory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getTableContent() {
		return tableContent;
	}

	public void setTableContent(Object tableContent) {
		this.tableContent = tableContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
