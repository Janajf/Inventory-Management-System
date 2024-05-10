package com.cd.inventorymanagementsystem.domain.computer.services;

import com.cd.inventorymanagementsystem.domain.computer.exceptions.ComputerException;
import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.cd.inventorymanagementsystem.domain.computer.repos.ComputerRepo;
import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ComputerServiceImplTests {
    @MockBean
    ComputerRepo mockComputerRepo;

    @Autowired
    ComputerService computerService;

    private Computer inputComputer;
    private Computer mockResponseComputer;
    private List<Computer> computers;
    private List<Loan> loans;
    private List<Maintenance> maintenances;

    @BeforeEach
    public void setUp(){
        computers = new ArrayList<>();
        loans = new ArrayList<>();
        maintenances = new ArrayList<>();

        inputComputer = Computer.builder()
                .assetTag("asset tag")
                .serialNumber("serial number")
                .status("status")
                .owner("owner")
                .brand("brand")
                .model("model")
                .type("type")
                .color("color")
                .issuedTo("issued")
                .grantType("type")
                .loaned(true)
                .loans(loans)
                .maintenances(maintenances)
                .build();

        mockResponseComputer = Computer.builder()
                .id(1)
                .assetTag("asset tag")
                .serialNumber("serial number")
                .status("status")
                .owner("owner")
                .brand("brand")
                .model("model")
                .type("type")
                .color("color")
                .issuedTo("issued")
                .grantType("type")
                .loaned(true)
                .loans(loans)
                .maintenances(maintenances)
                .build();
    }

    @Test
    @DisplayName("Computer Service: Create Computer Success")
    public void createComputerTestSuccess(){
        BDDMockito.doReturn(mockResponseComputer).when(mockComputerRepo).save(ArgumentMatchers.any());
        Computer returnedComputer = computerService.createComputer(inputComputer);
        Assertions.assertNotNull(returnedComputer, "Computer should not be null");
        Assertions.assertEquals(returnedComputer.getId(), 1);
    }

    @Test
    @DisplayName("Computer Service: Get computer by id - success")
    public void getComputerByIdTestSuccess() throws ComputerException {
        BDDMockito.doReturn(Optional.of(mockResponseComputer)).when(mockComputerRepo).findById(1);
        Computer foundComputer = computerService.getComputerById(1);
        Assertions.assertEquals(foundComputer.toString(), mockResponseComputer.toString());

    }

    @Test
    @DisplayName("Computer Service: Get computer by id - fail")
    public void getComputerByIdTestFail() throws ComputerException {
        BDDMockito.doReturn(Optional.empty()).when(mockComputerRepo).findById(1);
        Assertions.assertThrows(ComputerException.class, () ->{
            computerService.getComputerById(1);
        });
    }

    @Test
    @DisplayName("Computer Service: Update Computer - Success")
    public void updateComputerTestSuccess() throws ComputerException {

       Computer expectedComputerUpdate = Computer.builder()
                .id(1)
                .assetTag("asset tag")
                .serialNumber("serial number")
                .status("status")
                .owner("owner")
                .brand("brand")
                .model("model")
                .type("type")
                .color("color")
                .issuedTo("issued")
                .grantType("type")
                .loaned(true)
                .loans(loans)
                .maintenances(maintenances)
                .build();

       BDDMockito.doReturn(Optional.of(mockResponseComputer)).when(mockComputerRepo).findById(1);
       BDDMockito.doReturn(expectedComputerUpdate).when(mockComputerRepo).save(ArgumentMatchers.any());
       Computer actualComputer = computerService.updateComputerById(1,inputComputer);
       Assertions.assertEquals(expectedComputerUpdate.toString(), actualComputer.toString());

    }

    @Test
    @DisplayName("Computer Service: Update Computer - Fail")
    public void updateComputerTestFail() throws ComputerException {

        Computer expectedComputerUpdate = Computer.builder()
                .id(1)
                .assetTag("asset tag")
                .serialNumber("serial number")
                .status("status")
                .owner("owner")
                .brand("brand")
                .model("model")
                .type("type")
                .color("color")
                .issuedTo("issued")
                .grantType("type")
                .loaned(true)
                .loans(loans)
                .maintenances(maintenances)
                .build();

        BDDMockito.doReturn(Optional.empty()).when(mockComputerRepo).findById(1);
        Assertions.assertThrows(ComputerException.class, () ->{
            computerService.updateComputerById(1, inputComputer);
        });
    }

    @Test
    @DisplayName("Computer Service: Delete Computer - Success")
    public void deleteComputerTestSuccess() throws ComputerException {
        BDDMockito.doReturn(Optional.of(mockResponseComputer)).when(mockComputerRepo).findById(1);
        Boolean actualResponse = computerService.deleteComputerById(1);
        Assertions.assertTrue(actualResponse);
    }

    @Test
    @DisplayName("Computer Service: Delete Computer - Fail")
    public void deleteComputerTestFail(){
        BDDMockito.doReturn(Optional.empty()).when(mockComputerRepo).findById(1);
        Assertions.assertThrows(ComputerException.class, () ->{
            computerService.deleteComputerById(1);
        });
    }

}
