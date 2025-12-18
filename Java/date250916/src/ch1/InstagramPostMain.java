package ch1;

public class InstagramPostMain {

	public static void main(String[] args) {
		
		InstagramPost post1 = new InstagramPost("민지", "오늘 날씨 짱");

//		System.out.println("작성자: "+post1.writer);
//		System.out.println("내용: "+post1.text);
		
		System.out.println();
		
		//post1.setText("갑자기 비옴");
		System.out.println(post1.getText());
		
		//post1.setWriter("찬미");
		System.out.println(post1.getWriter());

	}

}

