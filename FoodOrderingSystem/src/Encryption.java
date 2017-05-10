import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

	public class Encryption {
	private String _password;
	public Encryption(String password){_password=password;}
	
	
	public String MakeToEncrypted() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		byte[] bytesOfMessage = _password.getBytes("UTF-8");
	
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		return ByteToString(thedigest);
	}
	 private String ByteToString (byte[] buffer){
		  StringBuilder s = new StringBuilder();
	
			for (byte b: buffer)
			{
	
				String temp = Integer.toHexString(0x00FF & b);
		
				if(temp.length()==1)
				{
				s.append( "0" +temp);
				}
		
				else
				{
					s.append(temp);
				}
	
		   }
	
		return s.toString();
		
		
	  }
	
}
