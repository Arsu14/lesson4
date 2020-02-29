package kz.one.lab.lesson4.rest;

import io.swagger.annotations.ApiOperation;
import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.DTO_all_arena_figther;
import kz.one.lab.lesson4.entity.Fighter;
import kz.one.lab.lesson4.repositories.ArenaRepository;
import kz.one.lab.lesson4.repositories.FighterRepository;
import kz.one.lab.lesson4.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("onelab")
@Slf4j
public class FightController {
    // Адрес ednpoint'a=onelab+fight = localhost:port/onelab/fight
    @Autowired
    ArenaRepository arenaRepository ;

    @Autowired
    FighterRepository fighterRepository;

    @Autowired
    FigtherService figtherService;

    @Autowired
    AddArenaService addArenaService ;


    @Autowired
    Arena arena;

    @Autowired
    CheckingDopingService dopingService;

    @GetMapping(value = "all")
    public Arena test(){
        return arenaRepository.findById(3L).get();
    }



///////////////////////////////////////////////////////////////////
    @ApiOperation("Add Arena")
    @PutMapping(value = "arena" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Arena> addArenaa(@RequestParam(name = "id") Long id,
                            @RequestParam(name = "name") String name) {
        return  addArenaService.addArena(id , name);

    }
///////////////////////////////////////////////////////////////////
        @ApiOperation("Delete Arena")
    @PutMapping(value = "delete" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Arena> deleteArenaa(@RequestParam(name = "id") Long id,
                                   @RequestParam(name = "name") String name){


        return addArenaService.deleteArena(id ,name ) ;

}
/////////////////////////////////////////
    @ApiOperation("Add to list fighter")
    @PutMapping(value = "addToFighter" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fighter> Add_To_fightere(@RequestBody Fighter fighter) {


        return figtherService.Add_To_fighter(fighter) ;
    }


    @ApiOperation("Add fighter to the Arena")
    @PutMapping(value = "FighterToArena" , produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Arena> AddToArenaa(@RequestBody DTO_all_arena_figther DTO_obj){

        return figtherService.FighterToArena(DTO_obj);
    };



//@ApiOperation("Add Fighter")
//    @PutMapping(value = "fight", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Fighter> helloOneLab(@RequestBody Fighter fighter)
//    {
//        Fighter fig = fighterRepository.save(fighter) ;
//
//
////        arena.getFighters().add(fighter) ;
//
//
//        log.info("test"+arena.getFighters().toString());
//
//        return new ResponseEntity(fig, HttpStatus.OK);
//    }








    @ApiOperation("Check All Fighters")
    @PostMapping(value = "check", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fighter> check(){
//        Arena arena_losers = arenaRepository.findById(2L).get();
//        Arena arena = arenaRepository.findById(14L).get();
        Arena arena = arenaRepository.findAll().get(0);
        Arena arena_losers = arenaRepository.findAll().get(1) ;

        List<Fighter> fighters =arena.getFighters();

        fighters.removeIf(fighter ->
        {
            if(!dopingService.checkFigher(fighter)){
            arena_losers.getFighters().add(fighter);
            return true;
        }
        else
            return false;
        });

        arena.setFighters(fighters);
        System.out.println("test");
        arenaRepository.save(arena_losers) ;
        arenaRepository.save(arena) ;

        log.info("Our warriors: "+arena.getFighters());

        return arena_losers.getFighters();
    }


}
