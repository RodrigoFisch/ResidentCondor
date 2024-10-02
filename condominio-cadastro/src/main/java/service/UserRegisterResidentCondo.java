package service;

import controller.Dto.ResidentCondoInPutDto;
import controller.Dto.ResidentCondoOutPutDto;
import domain.ResidentCondo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ResidentCondoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserRegisterResidentCondo {

    @Autowired
    private ResidentCondoRepository condoRepository;

    @Autowired
    private ModelMapper mapper;

    public ResidentCondoOutPutDto create (ResidentCondoInPutDto residentCondoInPutDto){
        ResidentCondo residentCondo = mapper.map(residentCondoInPutDto, ResidentCondo.class);
        condoRepository.save(residentCondo);
        ResidentCondoOutPutDto residentCondoOutPutDto = mapper.map(residentCondo, ResidentCondoOutPutDto.class);
        return residentCondoOutPutDto;
    }

    public ResidentCondoOutPutDto updateCpf(String cpf, ResidentCondoInPutDto residentCondoInPutDto){
        Optional<ResidentCondo> optional = condoRepository.findByCpf(cpf);
        ResidentCondo upDataRegister = optional.get();
        mapper.map(residentCondoInPutDto, upDataRegister);
        condoRepository.save(upDataRegister);
        ResidentCondoOutPutDto residentCondoOutPutDto = mapper.map(upDataRegister, ResidentCondoOutPutDto.class);
        return residentCondoOutPutDto;
    }

    public String deleteByCpf (String cpf){
        Optional<ResidentCondo> optional = condoRepository.findByCpf(cpf);
        condoRepository.delete(optional.get());
        return "Cadastro deletado com sucesso";
    }

    public ResidentCondoOutPutDto consultByCpf(String cpf){
        Optional<ResidentCondo> optional = condoRepository.findByCpf(cpf);
        ResidentCondo searchCpf = optional.get();
        ResidentCondoOutPutDto residentCondoOutPutDto = mapper.map(searchCpf, ResidentCondoOutPutDto.class);
        return residentCondoOutPutDto;
    }

    public List<ResidentCondoOutPutDto> residentCondorList(){
        List<ResidentCondo> residentCondos = condoRepository.findAll();
        List<ResidentCondoOutPutDto> residentCondoOutPutDtos = mapper.map(residentCondos, new TypeToken<List<ResidentCondoOutPutDto>>(){}.getType());
        return residentCondoOutPutDtos;
    }
}
