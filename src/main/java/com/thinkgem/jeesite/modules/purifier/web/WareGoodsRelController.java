package com.thinkgem.jeesite.modules.purifier.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.purifier.entity.WareGoodsRel;
import com.thinkgem.jeesite.modules.purifier.service.WareGoodsRelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请填写类注释
 *
 * @author addison
 * @since 2017年03月13日
 */
@Controller
@RequestMapping(value = "/wareGoodsRel")
public class WareGoodsRelController extends BaseController{

    @Autowired
    private WareGoodsRelService wareGoodsRelService;


    @ModelAttribute
    public WareGoodsRel get(@RequestParam(value = "id",required = false) Long id){
        if(id != null){
            return wareGoodsRelService.get(id.toString());
        }else {
            return new WareGoodsRel();
        }
    }

    @RequestMapping(value = "form")
    public String form(WareGoodsRel wareGoodsRel,Model model){
        model.addAttribute("wareGoodsRel",wareGoodsRel);
        return "modules/wareGoodsRel/wareGoodsRelForm";
    }

    @RequestMapping(value = "list")
    public String list(WareGoodsRel wareGoodsRel, HttpServletRequest request, HttpServletResponse response,Model model){
        Page<WareGoodsRel> page = wareGoodsRelService.findPage(new Page<WareGoodsRel>(request,response),wareGoodsRel);
        model.addAttribute("page", page);
        return "modules/wareGoodsRel/wareGoodsRelList";
    }

    @RequestMapping(value = "save")
    public String save(WareGoodsRel wareGoodsRel, Model model, RedirectAttributes redirectAttributes){
        if(!beanValidator(model,wareGoodsRel)){
            return form(wareGoodsRel,model);
        }
        wareGoodsRel.setIsNewRecord(true);
        wareGoodsRelService.save(wareGoodsRel);
        addMessage(model,"保存成功");
        return "modules/wareGoodsRel/wareGoodsRelList";
    }

    @RequestMapping(value = "update")
    public String update(WareGoodsRel wareGoodsRel, Model model, RedirectAttributes redirectAttributes){
        if(!beanValidator(model,wareGoodsRel)){
            return form(wareGoodsRel,model);
        }
        wareGoodsRelService.update(wareGoodsRel);
        addMessage(model,"保存成功");
        return "modules/wareGoodsRel/wareGoodsRelList";
    }

    @RequestMapping(value = "delete")
    public String delete(WareGoodsRel wareGoodsRel,Model model,RedirectAttributes redirectAttributes){
        wareGoodsRelService.delete(wareGoodsRel);
        addMessage(redirectAttributes, "删除成功");
        return "redirect:" + adminPath + "/ware/wareList";
    }


}