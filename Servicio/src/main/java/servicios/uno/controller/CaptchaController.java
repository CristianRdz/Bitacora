package servicios.uno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import servicios.uno.model.CaptchaResponse;
import servicios.uno.service.CaptchaService;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
@RequestMapping("/api")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @PostMapping("/verificar-captcha")
    public CaptchaResponse verificarCaptcha(@RequestParam("solution") String solution) {
        return captchaService.verificarCaptcha(solution);
    }

}
