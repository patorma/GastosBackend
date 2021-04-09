package com.patricio.contreras.GastosBackend.auth;

public class JwtConfig {
	
	// static significa que se puede accder de forma directa porque es un atributo de la
	// clase no del objeto. Se accede de la siguiente manera: el nombre de la clase.el_atributo 
	// y final no se puede cambiar el valor
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEAuu/7g3mDunJ053JJ80N63FZ07WoeRDeONXh+mPOUdZj8XLKB\r\n"
			+ "yJza/k4rUANO5LzpO9eaFLf06yyJm8A/kZ2v9TLPpo9MaP3N2lOS6YG3CoJ06lnp\r\n"
			+ "pJdS5joZg3BZd5CzekAoaP2eOJUYTtop8Ctg5iq+DwR8fy04aE+ZwRuZ72fFlV81\r\n"
			+ "n2SM1AechFtVEemM0+MmKO18RqDUlMAh5iKmLoPiBDUtx3FXqtXyweLiBTmp4A+J\r\n"
			+ "XdzdkvWWvhiJ4ONFWPd2t2EPW33EPNwxEmSNKxkS/8U1Qjox/hfp+3RFdtzvugbD\r\n"
			+ "wxCpucKWQTj3hdXz7ugRVg2cXymVc+YWXRl9AQIDAQABAoIBADmCjvwZrB72C2UQ\r\n"
			+ "0hNW1TtoFbzcgsc12Dg3A6uGdEvhbvINsMPJDc5iugx5mBHi1FYmtC5fkaewIf2a\r\n"
			+ "nXPs8S8cHKn/N+CtBGGAiJfx4iAHlnRqiOir7UMK6MJ5E+0mxTB9AHGcZMq/g6Tu\r\n"
			+ "lSxgDAWDbMkt9iciAFKG+qRgG3F9EobdyI3A8EeLYyaqekaTnp/dY/DoI3bKFs5M\r\n"
			+ "ga3VX+iC81RmTJ93eTU+9bZJIYpZofBz7zQzbrPbdRFbD0xsVcIyKmLmjx6wbU0N\r\n"
			+ "f1K7fp4rQh1GF58VhlcrKR1PwGoh/ABSzI4pxY6l6dO7DIQF8NJC9+FnUk2MJMF/\r\n"
			+ "ivtmx4ECgYEA57rQ3OSbtqnBrRxr/NTVQyy/UImnnJcXHJMyGoKw6IEzZjQZ3YJq\r\n"
			+ "qpJP14GAaSYT3Dz6VutVqum8dg1xG0nZiAodEw0mlH40IuJrNnYLiUVdvpXMUNjZ\r\n"
			+ "rIm07ol7r08zVgLKLxqGBC/fbJc03s4Lhg6acW1fQa+IDZOnWsiV8hkCgYEAzoQv\r\n"
			+ "ohmDAHdF4CSyDmdpsus40AgZgVWFVKibdnV1/CyA6aBLPrmisLFRuzHFsJ5nFp6D\r\n"
			+ "cCdg100kMOgdE1RU9IItClby0SNutMLaQkvC3e/qnD9opCYrTVmNG5ahIcy4bdSb\r\n"
			+ "kdPPMH2t7iT2z+ya594sOrU3ibsNgOWmdl5gTykCgYBCA7holT++49Fm7Yfd+Qvg\r\n"
			+ "HSlLWkvDkk9lNpG5d63KLrRj00fjELouaYwRSrU4Pz69KSnwBQ7cp8Wmo+Gq8njk\r\n"
			+ "Bm2N9dsdxm432eTNGQfkTTyNhMM17PDl9Dz1D3mK0bdAM39Bt/6hxrmRh+np5yzl\r\n"
			+ "PdfFpHDUl5rcs0mj1SzSUQKBgBwMXf/RITa9/FKOCVTlfLidM/ElOHmVaO9vmvXC\r\n"
			+ "zEx8quGQMMgLJGqFGsmm3+e2C+BJlSZ1YrS7OHAgBlrquEMhLwbZek8nVdDdKhGZ\r\n"
			+ "ApVsEVw5THgG6xitUfnuQmI50M6x8pMixmAaobXXdWIWC4/0X+N1W16sdhAMoMgw\r\n"
			+ "1znJAoGBALhcwtWtumbGu0xudsDY98RdP5lWc/GZxoUhgegUjutBzXO5ZpGdTJBu\r\n"
			+ "PTcE/AwN2ghdPsfI9jrUP2LwMKZowYxvSJui3yqaER1hmyOCDvS5q08lDDMogBJd\r\n"
			+ "cxEiyk9qcgQW3qrETKGoZmVbjonJUe7T7jDVVrDCvfmyAQPcGM/Y\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuu/7g3mDunJ053JJ80N6\r\n"
			+ "3FZ07WoeRDeONXh+mPOUdZj8XLKByJza/k4rUANO5LzpO9eaFLf06yyJm8A/kZ2v\r\n"
			+ "9TLPpo9MaP3N2lOS6YG3CoJ06lnppJdS5joZg3BZd5CzekAoaP2eOJUYTtop8Ctg\r\n"
			+ "5iq+DwR8fy04aE+ZwRuZ72fFlV81n2SM1AechFtVEemM0+MmKO18RqDUlMAh5iKm\r\n"
			+ "LoPiBDUtx3FXqtXyweLiBTmp4A+JXdzdkvWWvhiJ4ONFWPd2t2EPW33EPNwxEmSN\r\n"
			+ "KxkS/8U1Qjox/hfp+3RFdtzvugbDwxCpucKWQTj3hdXz7ugRVg2cXymVc+YWXRl9\r\n"
			+ "AQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
