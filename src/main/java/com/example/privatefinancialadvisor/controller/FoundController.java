package com.example.privatefinancialadvisor.controller;

import com.example.privatefinancialadvisor.beans.Found;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class FoundController {

    @RequestMapping("/found/info")
    public String queryAllFounds(Model model){
        InputStreamReader isr = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL("http://fund.eastmoney.com/js/fundcode_search.js");
            isr = new InputStreamReader(url.openStream());
            int character;
            while((character = isr.read()) != -1){
                sb.append((char)character);
            }
            String str = sb.toString();
            ArrayList<Found> founds = new ArrayList<>();
            String[] splits = str.split("\\[");
            for (int i = 2; i < splits.length; i++) {
                String[] split = splits[i].split("]")[0].split(",");
                String id = split[0].substring(1, split[0].length() - 1);
                String name = split[2].substring(1, split[2].length() - 1);
                String type = split[3].substring(1, split[3].length() - 1);
                String pinYinFullName = split[4].substring(1, split[4].length() - 1);
                String pinYinShortName = split[1].substring(1, split[1].length() - 1);
                Found found = new Found(id, name, type, pinYinFullName, pinYinShortName);
                founds.add(found);
            }
            model.addAttribute("foundInfo", founds);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "founds";
    }
}
