package com.example.prog_14615.domain.post.post;

import com.example.prog_14615.global.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component // bean 연결 (PostService 찾을 수 있게 하기 위함)
public class PostService {

    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post write(String title, String content) {

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        
        return postRepository.save(post);
    }

    public List<Post> getList() {
        return postRepository.findAll();
    }


    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public Post getIdList(Long id) {
        return postRepository.findById(id).get();
    }

    public void modify(Long id, String title, String content) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ServiceException("404", "게시물을 찾을 수 없음"));

        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);
    }
}
