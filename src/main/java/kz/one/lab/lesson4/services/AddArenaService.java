package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;

import java.util.List;

public interface AddArenaService {
    public List<Arena> addArena (Long id,String name) ;
    public List<Arena> deleteArena( Long id,String name);

}
