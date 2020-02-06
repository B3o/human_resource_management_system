package com.bemore.service.impl;

import com.bemore.dao.PositionDao;
import com.bemore.domain.Position;
import com.bemore.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bmo
 * @date 2020/2/5 16:36
 */

@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Position> findPositions(Map<String, Object> map) {
        return positionDao.findPositions(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return positionDao.getCount(map);
    }

    @Override
    public Integer addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    @Override
    public Integer updatePosition(Position position) {
        return positionDao.updatePosition(position);
    }

    @Override
    public Integer deletePosition(Integer id) {
        Integer flag = null;
        try {
            flag = positionDao.deletePosition(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
