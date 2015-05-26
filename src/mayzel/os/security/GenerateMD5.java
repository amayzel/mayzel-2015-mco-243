package mayzel.os.security;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class GenerateMD5 {
	
	public static void main(String [] args){
		String message = "I will graduate soon";
		System.out.println(DigestUtils.md5Hex(message));
	}
	
}
