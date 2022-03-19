package com.bysj.qiu.controller;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopItemType;
import com.bysj.qiu.service.AdminManagerShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/adminshopitem")
public class AdminShopItemController {

    @Autowired
    AdminManagerShopItemService adminManagerShopItemService;

    //展现商品列表
    @RequestMapping("/showallshopitem")
    @ResponseBody
    public List<ShopItem> showAllShopItem() {
        return adminManagerShopItemService.selAllShopItem();
    }

    //得到商品类型的列表
    @RequestMapping("/showallshopitemtype")
    @ResponseBody
    public List<ShopItemType> showAllShopItemType() {
        return adminManagerShopItemService.selAllShopItemType();
    }

    //得到果蔬图片
    @GetMapping(value = "/getforvImg", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getForVImg(HttpServletResponse response, String nowforvimg) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
        String realheadimgpath;
        if (nowforvimg != null) {
            realheadimgpath = "G:/毕业设计/邱/毕业设计果蔬图片库/" + nowforvimg;
        } else {
            realheadimgpath = "G:/毕业设计/邱/毕业设计果蔬图片库/headimg.png";
        }
        String imgPath = URLDecoder.decode(realheadimgpath, "utf-8");
        File file = new File(imgPath);
        if (file.exists()) {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        } else {
            return null;
        }
    }

    //   得到上传来的图片并更新进本地文件并对信息做出更新
    @RequestMapping("/doshopitemtolocal")
    @ResponseBody
    public String doShopItemToLocal(MultipartFile file_data, String name, BigDecimal price, String simpleintroduction, String type, int stockcount, int id) throws IOException {
        ShopItem shopItem = adminManagerShopItemService.selIsHaveShopInfo(name);
        if (file_data == null) {
            adminManagerShopItemService.upShopItemImg(shopItem.getForvpicture(), name, price, simpleintroduction, type, stockcount, id);
        } else {
            String filename = file_data.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            String newfilename = uuid + suffix;
            adminManagerShopItemService.upShopItemImg(newfilename, name, price, simpleintroduction, type, stockcount, id);
            file_data.transferTo(new File("G:/毕业设计/邱/毕业设计果蔬图片库/" + newfilename));
        }
        return "ok";
    }

    //增加商品项目
    @RequestMapping("/addshopiteminfo")
    @ResponseBody
    public String addShopItemInfo(MultipartFile file_data, String name, BigDecimal price, String simpleintroduction, String type, int stockcount) throws IOException {
        ShopItem shopItem = adminManagerShopItemService.selIsHaveShopInfo(name);
        if (file_data == null) {
            return "noallownull";
        } else {
            String filename = file_data.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            String newfilename = uuid + suffix;
            adminManagerShopItemService.addShopItemInfo(newfilename, name, price, simpleintroduction, type, stockcount);
            file_data.transferTo(new File("G:/毕业设计/邱/毕业设计果蔬图片库/" + newfilename));
            return "ok";
        }
    }

    //判断是否已经有这个商品了
    @RequestMapping("/booleanishaveshop")
    @ResponseBody
    public String booleanIsHaveShop(String name, String oldname) {
        ShopItem shopItem = adminManagerShopItemService.selIsHaveShopInfo(name);
        if (shopItem != null && !shopItem.equals(oldname)) {
            return "exist";
        } else {
            return "nohave";
        }
    }

    //删除商品
    @RequestMapping("/delshopitem")
    @ResponseBody
    public int delShopItemInfo(int id) {
        return adminManagerShopItemService.delShopItem(id);
    }
}
