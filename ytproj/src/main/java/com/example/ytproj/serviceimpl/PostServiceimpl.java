package com.example.ytproj.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ytproj.entities.Catrgory;
import com.example.ytproj.entities.Post;
import com.example.ytproj.entities.User;
import com.example.ytproj.payload.PostDto;
import com.example.ytproj.repositries.Categoryrepo;
import com.example.ytproj.repositries.PostRepo;
import com.example.ytproj.repositries.Repo;
import com.example.ytproj.service.PostService;

@Service
public class PostServiceimpl implements PostService {
    @Autowired
    PostRepo ps;
    @Autowired
    ModelMapper mm;
    @Autowired
    Categoryrepo cr;
    @Autowired
    Repo rs;

    @Override
    public PostDto createPost(PostDto pt, int uid, int cid) {
        // TODO Auto-generated method stub

        User u = rs.findById(uid).get();
        Catrgory ct = cr.findById(cid).get();

        Post np = mm.map(pt, Post.class);
        np.setImagename("default.png");
        np.setDate(new Date());
        np.setU(u);
        np.setCt(ct);

        Post save = ps.save(np);
        return mm.map(np, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto pt, int id) {
        // TODO Auto-generated method stub]
        Post op = ps.findById(id).get();
        op.setContent(pt.getContent());
        op.setImagename(pt.getImagename());
        op.setTitle(pt.getTitle());
        Post np = ps.save(op);
        return mm.map(np, PostDto.class);
    }

    @Override
    public void deletePost(int id) {
        // TODO Auto-generated method stub
        ps.deleteById(id);
    }

    @Override
    public PostDto getPost(int id) {
        // TODO Auto-generated method stub
        Post p = ps.findById(id).get();
        return mm.map(p, PostDto.class);

    }

    @Override
    public List<PostDto> getAllPost(int pagesize, int pagenumber) {
        // TODO Auto-generated method stub

        PageRequest pq = PageRequest.of(pagenumber, pagesize);
        Page<Post> li = ps.findAll(pq);
        List<PostDto> nli = new ArrayList<>();
        for (Post p : li) {
            nli.add(mm.map(p, PostDto.class));
        }
        return nli;
    }

    public List<PostDto> getPostByCategory(int cid) {
        // TODO Auto-generated method stub
        Catrgory ct = cr.findById(cid).get();
        List<Post> li = ps.findByCt(ct);
        List<PostDto> nli = new ArrayList<PostDto>();
        for (Post p : li) {
            nli.add(mm.map(p, PostDto.class));
        }
        return nli;
    }

    @Override
    public List<PostDto> getAllPostByUser(int uid) {
        // TODO Auto-generated method stub
        User u = rs.findById(uid).get();
        List<Post> li = ps.findByU(u);
        List<PostDto> nli = new ArrayList<>();
        for (Post p : li) {
            nli.add(mm.map(p, PostDto.class));
        }
        return nli;
    }

    @Override
    public List<PostDto> searchPost(String key) {
        // TODO Auto-generated method stub
        return null;
    }

}
