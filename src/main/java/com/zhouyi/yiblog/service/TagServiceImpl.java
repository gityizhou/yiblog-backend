package com.zhouyi.yiblog.service;

import com.zhouyi.yiblog.NotFoundException;
import com.zhouyi.yiblog.dao.TagRepository;
import com.zhouyi.yiblog.po.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public Tag getTag(Long id) {
        Optional<Tag> getTag = tagRepository.findById(id);
        Tag t = getTag.orElse(null);
        if (t == null) {
            throw new NotFoundException("该标签不存在");
        }
        return t;
    }

    @Override
    @Transactional
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    @Transactional
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        Optional<Tag> getType = tagRepository.findById(id);
        Tag t = getType.orElse(null);
        if (t == null) {
            throw new NotFoundException("该标签不存在");
        }
        BeanUtils.copyProperties(tag, t);
        return tagRepository.save(t);
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {  //1,2,3
        return tagRepository.findAllById(convertToList(ids));
    }

    public List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if("".equals(ids) && ids !=null){
            String[] idarray = ids.split(",");
            for(int i=0; i < idarray.length; i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
}
