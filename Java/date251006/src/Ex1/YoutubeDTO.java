package Ex1;

import java.sql.Date;

public class YoutubeDTO {

	private int id;
	private String title;
	private String ch_name;
	private Date upload;
	private int views;
	private int likes;

	public YoutubeDTO() {
	}

	// DB에 입력 시
	public YoutubeDTO(String title, String ch_name, Date upload, int views, int likes) {
		this.title = title;
		this.ch_name = ch_name;
		this.upload = upload;
		this.views = views;
		this.likes = likes;
	}

	// DB로부터 읽어올 때
	public YoutubeDTO(int id, String title, String ch_name, Date upload, int views, int likes) {
		this.id = id;
		this.title = title;
		this.ch_name = ch_name;
		this.upload = upload;
		this.views = views;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCh_name() {
		return ch_name;
	}

	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}

	public Date getUpload() {
		return upload;
	}

	public void setUpload(Date upload) {
		this.upload = upload;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return String.format("%d번 | 제목: %s | 채널명: %s | 업로드 날짜: %s | 조회수: %d | 좋아요: %d", id, title, ch_name, upload,
				views, likes);
	}

}
