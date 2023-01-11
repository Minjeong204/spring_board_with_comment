package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	private Long[] bnoArr = { 3145745L, 3145744L, 3145743L, 3145742L, 3145741L };
	@Autowired
	private ReplyMapper mapper;

	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();

			vo.setBno(1L);
			vo.setReply("´ñ±Û Å×½ºÆ® " + i);
			vo.setReplyer("replyer" + i);

			mapper.insert(vo);
		});
	}

	public void testMapper() {
		log.info(mapper);
	}

	public void testRead() {
		Long targetRno = 1L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}

	public void testDelete() {
		Long targetRno = 1L;
		mapper.delete(targetRno);
	}

	public void testUpdate() {
		Long targetRno = 10L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply ");
		int count = mapper.update(vo);
		log.info("update count: " + count);
	}

	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[1]);

		replies.forEach(reply -> log.info(reply));
	}

	@Test
	public void testList2() {
		Criteria cri = new Criteria(1, 10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 1L);
		replies.forEach(reply -> log.info(reply));
	}
}
