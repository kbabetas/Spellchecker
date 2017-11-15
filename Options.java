public class OptionsTest {

public static int LevenshteinDistance( String s1, String s2) {
	//upologizei poses allages xreiazonte gia na ginoun ta duo string idia
	int sl1 = s1.length() ;
	int sl2 = s2.length();
	if (sl1 == 0) {
		return sl2 ;
	}
	if (sl2==0) {
		return sl1;
	}
	int[][] dis =new int[sl1+1][sl2+1];
	for (int i=0;i<=sl1;i++){
		for (int j=0;j<=sl2;j++) {
			if (i==0) {
				dis[i][j] = j;
			}
			if (j==0) {
				dis[i][j] = i;
			}


			 if (i!=0 && j!=0) {
			 				if ( s1.charAt(i-1)!= s2.charAt(j-1)) {
			 					// an o xaraktiras den einai idios o pinakas pairnei san timi
			 					// to min twn dis[(i-1)][j]+1 , dis[i][(j-1)]+1 , dis[(i-1)][(j-1)] kai prosthetw 1
			 					// ara toses allages xreiazonte mexri auto to simio gia na ginoun idia ta duo strings

			 					 int a = Math.min( dis[(i-1)][j] , dis[i][(j-1)]);
			 					 dis[i][j] = Math.min(dis[(i-1)][(j-1)] , a)+1;


			 				 } else {
			 				  //an o xaraktiras einai idios pairnei thn timi tou pinaka
			 				 //pou einai diagonia apo ti thesi pou vriskomaste afou den
			 				 //xreiazetai pereterw allagi giauton ton xaraktira

			 					 dis[i][j] = dis[(i-1)][(j-1)];

			 				 }
			 }

		 }
	 }

	 return dis[sl1][sl2];
 }

public static double similarity(String s1, String s2) {
 int d = LevenshteinDistance(s1,s2);
 double sim = (Math.max(s1.length(), s2.length())- d) / (double)(Math.max(s1.length(), s2.length()));
 return sim;
 }


}
