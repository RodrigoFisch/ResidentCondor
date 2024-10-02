package controller;

import controller.Dto.ResidentCondoInPutDto;
import controller.Dto.ResidentCondoOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserRegisterResidentCondo;

import java.util.List;

@RestController
@RequestMapping
public class ResidentCondorController {

    @Autowired
    private UserRegisterResidentCondo service;

    //Definir os logs usando Log$j2

    @PostMapping
    public ResidentCondoOutPutDto create(@RequestBody ResidentCondoInPutDto residentCondoInPutDto){
        return service.create(residentCondoInPutDto);
    }

    @PutMapping("cpf/{cpf}")
    public ResidentCondoOutPutDto upDateCpf(@PathVariable("cpf") String cpf,
                                              @RequestBody ResidentCondoInPutDto residentCondoInPutDto){
        return service.updateCpf(cpf,residentCondoInPutDto);
    }

    @DeleteMapping("cpf/{cpf}")
    public String deleteByCpf(@PathVariable("cpf")String cpf){
        return service.deleteByCpf(cpf);
    }

    @GetMapping("cpf/{cpf}")
    public ResidentCondoOutPutDto consultByCpf(@PathVariable("cpf") String cpf){
        return service.consultByCpf(cpf);
    }
    @GetMapping ("all")
    public List<ResidentCondoOutPutDto> residentCondoList(){
        return service.residentCondorList();
    }
}
