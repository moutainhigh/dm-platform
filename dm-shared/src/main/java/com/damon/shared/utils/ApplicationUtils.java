package com.damon.shared.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author Damon S.
 */
public final class ApplicationUtils {

    /**
     * 获取本地MAC地址
     **/
    public static String findLocalMac() throws SocketException, UnknownHostException {
        //获取网卡，获取地址
        InetAddress address = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(address).getHardwareAddress();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                builder.append("-");
            }
            // mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            builder.append(s.length() == 1 ? 0 + s : s);
        }
        // 把字符串所有小写字母改为大写成为正规的mac地址并返回
        return builder.toString().toUpperCase().replaceAll("-", "");
    }
}