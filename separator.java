 class separator{
	  public static void main (String[] args){
		  String s = "ABC[ This is  extract]";
    	int startIndex = s.indexOf('[');
    	int endIndex = s.indexOf(']');
    	System.out.println(s.substring(startIndex + 1, endIndex));
    }
}
