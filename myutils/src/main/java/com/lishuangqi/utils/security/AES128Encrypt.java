package com.lishuangqi.utils.security;

/**
 * Created by michael on 2017/9/11.
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES128Encrypt {
    public String decrypt(String input)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, IllegalBlockSizeException, BadPaddingException {
        return decrypt(input, createSecretKey());
    }

    public static String decrypt(String input, byte[] keyValue)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] data = decoder.decodeBuffer(input);
        byte[] decryptData = cipher.doFinal(data, 0, data.length);

        return new String(decryptData);
    }

    public static String encrypt(String input)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, IllegalBlockSizeException, BadPaddingException {
        return encrypt(input, createSecretKey());
    }

    public static String encrypt(String input, byte[] keyValue)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, key);
        byte[] bs = cipher.doFinal(input.getBytes());

        return new BASE64Encoder().encode(bs).replaceAll("\r\n", "").replaceAll("\n", "");
    }

    public static byte[] createSecretKey() {
        return new byte[]{104, 117, 97, 119, 101, 105, 95, 99, 100, 115, 102,
                95, 112, 97, 115, 115};
    }

    public byte[] createKey() {
        char[] key = new char['Ȁ'];
        key[0] = '';
        key[1] = 'é';
        key[2] = '\033';
        key[3] = '*';
        key[4] = '*';
        key[5] = '¬';
        key[6] = 'Ý';
        key[7] = '';
        key[8] = 'Ò';
        key[9] = 'Ñ';
        key[10] = '«';
        key[11] = 'p';
        key[12] = 'ô';
        key[13] = '';
        key[14] = 'S';
        key[15] = 'ô';
        key[16] = 'J';
        key[17] = '¦';
        key[18] = 'é';
        key[19] = 'B';
        key[20] = '(';
        key[21] = '¦';
        key[22] = 'å';
        key[23] = 'É';
        key[24] = '>';
        key[25] = 'Á';
        key[26] = '';
        key[27] = '';
        key[28] = 'Ý';
        key[29] = 'T';
        key[30] = 't';
        key[31] = '\013';
        key[32] = 'b';
        key[33] = '';
        key[34] = 'é';
        key[35] = '\033';
        key[36] = '*';
        key[37] = '¬';
        key[38] = 'Ý';
        key[39] = '';
        key[40] = 'Ò';
        key[41] = 'Ñ';
        key[42] = '«';
        key[43] = 'p';
        key[44] = 'ô';
        key[45] = '';
        key[46] = 'S';
        key[47] = 'ô';
        key[48] = 'J';
        key[49] = '¦';
        key[50] = 'é';
        key[51] = 'B';
        key[52] = '(';
        key[53] = '¦';
        key[54] = 'å';
        key[55] = 'É';
        key[56] = '>';
        key[57] = 'Á';
        key[58] = '';
        key[59] = '';
        key[60] = 'Ý';
        key[61] = 'T';
        key[62] = 't';
        key[63] = '\013';
        key[64] = 'b';
        key[65] = '';
        key[66] = 'é';
        key[67] = '\033';
        key[68] = '*';
        key[69] = '¬';
        key[70] = 'Ý';
        key[71] = '';
        key[72] = 'Ò';
        key[73] = 'Ñ';
        key[74] = '«';
        key[75] = 'p';
        key[76] = 'ô';
        key[77] = '';
        key[78] = 'S';
        key[79] = 'ô';
        key[80] = 'J';
        key[81] = '¦';
        key[82] = 'é';
        key[83] = 'B';
        key[84] = '(';
        key[85] = '¦';
        key[86] = 'å';
        key[87] = 'É';
        key[88] = '>';
        key[89] = 'Á';
        key[90] = '';
        key[91] = '';
        key[92] = 'Ý';
        key[93] = 'T';
        key[94] = 't';
        key[95] = '\013';
        key[96] = 'b';
        key[97] = '';
        key[98] = 'é';
        key[99] = '\033';
        key[100] = '*';
        key[101] = '¬';
        key[102] = 'Ý';
        key[103] = '';
        key[104] = 'Ò';
        key[105] = 'Ñ';
        key[106] = '«';
        key[107] = 'p';
        key[108] = 'ô';
        key[109] = '';
        key[110] = 'S';
        key[111] = 'ô';
        key[112] = 'J';
        key[113] = '¦';
        key[114] = 'é';
        key[115] = 'B';
        key[116] = '(';
        key[117] = '¦';
        key[118] = 'å';
        key[119] = 'É';
        key[120] = '>';
        key[121] = 'Á';
        key[122] = '';
        key[123] = '';
        key[124] = 'Ý';
        key[125] = 'T';
        key[126] = 't';
        key[127] = '\013';
        key[''] = 'b';
        key[''] = '';
        key[''] = 'é';
        key[''] = '\033';
        key[''] = '*';
        key[''] = '¬';
        key[''] = 'Ý';
        key[''] = '';
        key[''] = 'Ò';
        key[''] = 'Ñ';
        key[''] = '«';
        key[''] = 'p';
        key[''] = 'ô';
        key[''] = '';
        key[''] = 'S';
        key[''] = 'ô';
        key[''] = 'J';
        key[''] = '¦';
        key[''] = 'é';
        key[''] = 'B';
        key[''] = '(';
        key[''] = '¦';
        key[''] = 'å';
        key[''] = 'É';
        key[''] = '>';
        key[''] = 'Á';
        key[''] = '';
        key[''] = '';
        key[''] = 'Ý';
        key[''] = 'T';
        key[''] = 't';
        key[''] = '\013';
        key[' '] = 'b';
        key['¡'] = '';
        key['¢'] = 'é';
        key['£'] = '\033';
        key['¤'] = '*';
        key['¥'] = '¬';
        key['¦'] = 'Ý';
        key['§'] = '';
        key['¨'] = 'Ò';
        key['©'] = 'Ñ';
        key['ª'] = '«';
        key['«'] = 'p';
        key['¬'] = 'ô';
        key['­'] = '';
        key['®'] = 'S';
        key['¯'] = 'ô';
        key['°'] = 'J';
        key['±'] = '¦';
        key['²'] = 'é';
        key['³'] = 'B';
        key['´'] = '(';
        key['µ'] = '¦';
        key['¶'] = 'å';
        key['·'] = 'É';
        key['¸'] = '>';
        key['¹'] = 'Á';
        key['º'] = '';
        key['»'] = '';
        key['¼'] = 'Ý';
        key['½'] = 'T';
        key['¾'] = 't';
        key['¿'] = '\013';
        key['À'] = 'b';
        key['Á'] = '';
        key['Â'] = 'é';
        key['Ã'] = '\033';
        key['Ä'] = '*';
        key['Å'] = '¬';
        key['Æ'] = 'Ý';
        key['Ç'] = '';
        key['È'] = 'Ò';
        key['É'] = 'Ñ';
        key['Ê'] = '«';
        key['Ë'] = 'p';
        key['Ì'] = 'ô';
        key['Í'] = '';
        key['Î'] = 'S';
        key['Ï'] = 'ô';
        key['Ð'] = 'J';
        key['Ñ'] = '¦';
        key['Ò'] = 'é';
        key['Ó'] = 'B';
        key['Ô'] = '(';
        key['Õ'] = '¦';
        key['Ö'] = 'å';
        key['×'] = 'É';
        key['Ø'] = '>';
        key['Ù'] = 'Á';
        key['Ú'] = '';
        key['Û'] = '';
        key['Ü'] = 'Ý';
        key['Ý'] = 'T';
        key['Þ'] = 't';
        key['ß'] = '\013';
        key['à'] = 'b';
        key['á'] = '';
        key['â'] = 'é';
        key['ã'] = '\033';
        key['ä'] = '*';
        key['å'] = '¬';
        key['æ'] = 'Ý';
        key['ç'] = '';
        key['è'] = 'Ò';
        key['é'] = 'Ñ';
        key['ê'] = '«';
        key['ë'] = 'p';
        key['ì'] = 'ô';
        key['í'] = '';
        key['î'] = 'S';
        key['ï'] = 'ô';
        key['ð'] = 'J';
        key['ñ'] = '¦';
        key['ò'] = 'é';
        key['ó'] = 'B';
        key['ô'] = '(';
        key['õ'] = '¦';
        key['ö'] = 'å';
        key['÷'] = 'É';
        key['ø'] = '>';
        key['ù'] = 'Á';
        key['ú'] = '';
        key['û'] = '';
        key['ü'] = 'Ý';
        key['ý'] = 'T';
        key['þ'] = 't';
        key['ÿ'] = '\013';
        key['Ā'] = 'b';
        key['ā'] = '';
        key['Ă'] = 'é';
        key['ă'] = '\033';
        key['Ą'] = '*';
        key['ą'] = '¬';
        key['Ć'] = 'Ý';
        key['ć'] = '';
        key['Ĉ'] = 'Ò';
        key['ĉ'] = 'Ñ';
        key['Ċ'] = '«';
        key['ċ'] = 'p';
        key['Č'] = 'ô';
        key['č'] = '';
        key['Ď'] = 'S';
        key['ď'] = 'ô';
        key['Đ'] = 'J';
        key['đ'] = '¦';
        key['Ē'] = 'é';
        key['ē'] = 'B';
        key['Ĕ'] = '(';
        key['ĕ'] = '¦';
        key['Ė'] = 'å';
        key['ė'] = 'É';
        key['Ę'] = '>';
        key['ę'] = 'Á';
        key['Ě'] = '';
        key['ě'] = '';
        key['Ĝ'] = 'Ý';
        key['ĝ'] = 'T';
        key['Ğ'] = 't';
        key['ğ'] = '\013';
        key['Ġ'] = 'b';
        key['ġ'] = '';
        key['Ģ'] = 'é';
        key['ģ'] = '\033';
        key['Ĥ'] = '*';
        key['ĥ'] = '¬';
        key['Ħ'] = 'Ý';
        key['ħ'] = '';
        key['Ĩ'] = 'Ò';
        key['ĩ'] = 'Ñ';
        key['Ī'] = '«';
        key['ī'] = 'p';
        key['Ĭ'] = 'ô';
        key['ĭ'] = '';
        key['Į'] = 'S';
        key['į'] = 'ô';
        key['İ'] = 'J';
        key['ı'] = '¦';
        key['Ĳ'] = 'é';
        key['ĳ'] = 'B';
        key['Ĵ'] = '(';
        key['ĵ'] = '¦';
        key['Ķ'] = 'å';
        key['ķ'] = 'É';
        key['ĸ'] = '>';
        key['Ĺ'] = 'Á';
        key['ĺ'] = '';
        key['Ļ'] = '';
        key['ļ'] = 'Ý';
        key['Ľ'] = 'T';
        key['ľ'] = 't';
        key['Ŀ'] = '\013';
        key['ŀ'] = 'b';
        key['Ł'] = '';
        key['ł'] = 'é';
        key['Ń'] = '\033';
        key['ń'] = '*';
        key['Ņ'] = '¬';
        key['ņ'] = 'Ý';
        key['Ň'] = '';
        key['ň'] = 'Ò';
        key['ŉ'] = 'Ñ';
        key['Ŋ'] = '«';
        key['ŋ'] = 'p';
        key['Ō'] = 'ô';
        key['ō'] = '';
        key['Ŏ'] = 'S';
        key['ŏ'] = 'ô';
        key['Ő'] = 'J';
        key['ő'] = '¦';
        key['Œ'] = 'é';
        key['œ'] = 'B';
        key['Ŕ'] = '(';
        key['ŕ'] = '¦';
        key['Ŗ'] = 'å';
        key['ŗ'] = 'É';
        key['Ř'] = '>';
        key['ř'] = 'Á';
        key['Ś'] = '';
        key['ś'] = '';
        key['Ŝ'] = 'Ý';
        key['ŝ'] = 'T';
        key['Ş'] = 't';
        key['ş'] = '\013';
        key['Š'] = 'b';
        key['š'] = '';
        key['Ţ'] = 'é';
        key['ţ'] = '\033';
        key['Ť'] = '*';
        key['ť'] = '¬';
        key['Ŧ'] = 'Ý';
        key['ŧ'] = '';
        key['Ũ'] = 'Ò';
        key['ũ'] = 'Ñ';
        key['Ū'] = '«';
        key['ū'] = 'p';
        key['Ŭ'] = 'ô';
        key['ŭ'] = '';
        key['Ů'] = 'S';
        key['ů'] = 'ô';
        key['Ű'] = 'J';
        key['ű'] = '¦';
        key['Ų'] = 'é';
        key['ų'] = 'B';
        key['Ŵ'] = '(';
        key['ŵ'] = '¦';
        key['Ŷ'] = 'å';
        key['ŷ'] = 'É';
        key['Ÿ'] = '>';
        key['Ź'] = 'Á';
        key['ź'] = '';
        key['Ż'] = '';
        key['ż'] = 'Ý';
        key['Ž'] = 'T';
        key['ž'] = 't';
        key['ſ'] = '\013';
        key['ƀ'] = 'b';
        key['Ɓ'] = '';
        key['Ƃ'] = 'é';
        key['ƃ'] = '\033';
        key['Ƅ'] = '*';
        key['ƅ'] = '¬';
        key['Ɔ'] = 'Ý';
        key['Ƈ'] = '';
        key['ƈ'] = 'Ò';
        key['Ɖ'] = 'Ñ';
        key['Ɗ'] = '«';
        key['Ƌ'] = 'p';
        key['ƌ'] = 'ô';
        key['ƍ'] = '';
        key['Ǝ'] = 'S';
        key['Ə'] = 'ô';
        key['Ɛ'] = 'J';
        key['Ƒ'] = '¦';
        key['ƒ'] = 'é';
        key['Ɠ'] = 'B';
        key['Ɣ'] = '(';
        key['ƕ'] = '¦';
        key['Ɩ'] = 'å';
        key['Ɨ'] = 'É';
        key['Ƙ'] = '>';
        key['ƙ'] = 'Á';
        key['ƚ'] = '';
        key['ƛ'] = '';
        key['Ɯ'] = 'Ý';
        key['Ɲ'] = 'T';
        key['ƞ'] = 't';
        key['Ɵ'] = '\013';
        key['Ơ'] = 'b';
        key['ơ'] = '';
        key['Ƣ'] = 'é';
        key['ƣ'] = '\033';
        key['Ƥ'] = '*';
        key['ƥ'] = '¬';
        key['Ʀ'] = 'Ý';
        key['Ƨ'] = '';
        key['ƨ'] = 'Ò';
        key['Ʃ'] = 'Ñ';
        key['ƪ'] = '«';
        key['ƫ'] = 'p';
        key['Ƭ'] = 'ô';
        key['ƭ'] = '';
        key['Ʈ'] = 'S';
        key['Ư'] = 'ô';
        key['ư'] = 'J';
        key['Ʊ'] = '¦';
        key['Ʋ'] = 'é';
        key['Ƴ'] = 'B';
        key['ƴ'] = '(';
        key['Ƶ'] = '¦';
        key['ƶ'] = 'å';
        key['Ʒ'] = 'É';
        key['Ƹ'] = '>';
        key['ƹ'] = 'Á';
        key['ƺ'] = '';
        key['ƻ'] = '';
        key['Ƽ'] = 'Ý';
        key['ƽ'] = 'T';
        key['ƾ'] = 't';
        key['ƿ'] = '\013';
        key['ǀ'] = 'b';
        key['ǁ'] = '';
        key['ǂ'] = 'é';
        key['ǃ'] = '\033';
        key['Ǆ'] = '*';
        key['ǅ'] = '¬';
        key['ǆ'] = 'Ý';
        key['Ǉ'] = '';
        key['ǈ'] = 'Ò';
        key['ǉ'] = 'Ñ';
        key['Ǌ'] = '«';
        key['ǋ'] = 'p';
        key['ǌ'] = 'ô';
        key['Ǎ'] = '';
        key['ǎ'] = 'S';
        key['Ǐ'] = 'ô';
        key['ǐ'] = 'J';
        key['Ǒ'] = '¦';
        key['ǒ'] = 'é';
        key['Ǔ'] = 'B';
        key['ǔ'] = '(';
        key['Ǖ'] = '¦';
        key['ǖ'] = 'å';
        key['Ǘ'] = 'É';
        key['ǘ'] = '>';
        key['Ǚ'] = 'Á';
        key['ǚ'] = '';
        key['Ǜ'] = '';
        key['ǜ'] = 'Ý';
        key['ǝ'] = 'T';
        key['Ǟ'] = 't';
        key['ǟ'] = '\013';
        key['Ǡ'] = 'b';
        key['ǡ'] = '';
        key['Ǣ'] = 'é';
        key['ǣ'] = '\033';
        key['Ǥ'] = '*';
        key['ǥ'] = '¬';
        key['Ǧ'] = 'Ý';
        key['ǧ'] = '';
        key['Ǩ'] = 'Ò';
        key['ǩ'] = 'Ñ';
        key['Ǫ'] = '«';
        key['ǫ'] = 'p';
        key['Ǭ'] = 'ô';
        key['ǭ'] = '';
        key['Ǯ'] = 'S';
        key['ǯ'] = 'ô';
        key['ǰ'] = 'J';
        key['Ǳ'] = '¦';
        key['ǲ'] = 'é';
        key['ǳ'] = 'B';
        key['Ǵ'] = '(';
        key['ǵ'] = '¦';
        key['Ƕ'] = 'å';
        key['Ƿ'] = 'É';
        key['Ǹ'] = '>';
        key['ǹ'] = 'Á';
        key['Ǻ'] = '';
        key['ǻ'] = '';
        key['Ǽ'] = 'Ý';
        key['ǽ'] = 'T';
        key['Ǿ'] = 't';
        key['ǿ'] = '\013';

        byte[] aes_key = new byte[16];
        int i = 0;
        for (int k = 1; i < aes_key.length; i++) {
            k += i * 3;
            aes_key[i] = ((byte) key[k]);
        }
        return aes_key;
    }

    public static void main(String[] args)
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
        AES128Encrypt aes = new AES128Encrypt();
//        int i = 3;
//        BufferedReader reader = null;
//        do {
//            pln("************************************");
//            pln("Please input your password:");
//            String s = "";
//            reader = new BufferedReader(new InputStreamReader(System.in));
//            s = reader.readLine();
//            if ((s != null) && (!"".equals(s.trim()))) {
//                pln("The AES128 code is:\n" +
//                        aes.encrypt(s.trim()));
//
//                break;
//            }
////            if ((s != null) && (!"".equals(s.trim()))) {
////                com.huawei.util.security.AES128Encrypt aaa= new com.huawei.util.security.AES128Encrypt();
////                pln("The AES128 code is:\n" +
////                aaa.encrypt(s));
////                break;
////            }
//            pln( "You input error data!Only " + --i + " times!");
//        } while (i != 0);
//        reader.close();
        System.out.println(aes.decrypt("r38Tys90uIRwrCyNXN87tg=="));
        System.out.println(aes.decrypt("Twnz2iFv6GHJKFMd/65khQ=="));
        pln("************************************\nQuit Now!");
    }

    private static void pln(String s) {
        System.out.println(s);
    }
}
