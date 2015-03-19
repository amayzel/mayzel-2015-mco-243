package mayzel.downloadingPics;

public class Main {

	public Main() {
		ThreadOne t1 = new ThreadOne("http://images.fineartamerica.com/images-medium-large/smiley-face-symbols-detlev-van-ravenswaay.jpg","1");
		t1.start();
		ThreadOne t2 = new ThreadOne("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSZrajzoEXNlRWjMGE9L3kqI1EsFN9P5HCNhMo4xaqLkWuhAixo","2");
		t2.start();
		ThreadOne t3 = new ThreadOne("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSsHPbHQWZEjzpkfi9GL2GJSC-r-BSA5xp-fO1_aI4uGwapzAiT","3");
		t3.start();
	}

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println("Download complete!");

	}

}
