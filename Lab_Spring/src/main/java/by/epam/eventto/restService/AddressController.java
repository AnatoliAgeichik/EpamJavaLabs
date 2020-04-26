package by.epam.eventto.restService;


import by.epam.eventto.entity.Address;
import by.epam.eventto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getEntity(id));
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAllAddresses(){
        return ResponseEntity.ok(addressService.getData());
    }

    @PutMapping("/address")
    public ResponseEntity<Void> updateAddress(@RequestParam Address address){
        addressService.update(address);
        return ResponseEntity.ok().build();
    }

    @PostMapping ("/address")
    public ResponseEntity<Void> createAddress(@RequestParam Address address){
        addressService.create(address);
        return ResponseEntity.ok().build();
    }


}
