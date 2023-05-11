package com.shop;

import com.shop.answer.Answer;
import com.shop.answer.AnswerRepository;
import com.shop.question.Question;
import com.shop.question.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ShopApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	private AnswerRepository answerRepository;



	@Test
	@DisplayName("질문 답변 테스트")
	void testJpa1() {
		Question q1 = new Question();
		q1.setSubject("소금빵은 무슨맛인가요?");
		q1.setContent("소금빵을 먹어본적이 없어서 궁금하네요.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("식빵 재고는 얼마나 있나요?");
		q2.setContent("대량주문 하려합니다.");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장
	}

	@Test
	@DisplayName("데이터 조회 테스트")
	void testJpa2() {
		Question q1 = new Question();
		q1.setSubject("소금빵은 무슨맛인가요?");
		q1.setContent("소금빵을 먹어본적이 없어서 궁금하네요.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("식빵 재고는 얼마나 있나요?");
		q2.setContent("대량주문 하려합니다.");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장

		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("소금빵은 무슨맛인가요?", q.getSubject());
	}

	@Test
	@DisplayName("Id값으로 데이터 조회 테스트")
	void testJpa3() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("소금빵은 무슨맛인가요?", q.getSubject());
		}
	}

	@Test
	@DisplayName("subject으로 데이터 조회 테스트")
	void testJpa4() {
		Question q = this.questionRepository.findBySubject("소금빵은 무슨맛인가요?");
		assertEquals(1, q.getId());
	}

	@Test
	@DisplayName("제목과 내용 데이터 조회 테스트")
	void testJpa5() {
		Question q = this.questionRepository.findBySubjectAndContent(
				"소금빵은 무슨맛인가요?", "소금빵을 먹어본적이 없어서 궁금하네요.");
		assertEquals(1, q.getId());
	}
	@Test
	@DisplayName("특정 문자열 포함 데이터 조회 테스트")
	void testJpa6() {
		List<Question> qList = this.questionRepository.findBySubjectLike("소금빵%");
		Question q = qList.get(0);
		assertEquals("소금빵은 무슨맛인가요?", q.getSubject());
	}

	@Test
	@DisplayName("데이터 수정 테스트")
	void testJpa7() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}

	@Test
	@DisplayName("질문 삭제 테스트")
	void testJpa8() {
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}

	@Test
	@DisplayName("답변 데이터 생성 후 저장 & 답변 조회 테스트")
	void testJpa9() {
		Optional<Question> oq = this.questionRepository.findById(2); //답변 데이터 생성 후 저장 테스트
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 충분합니다.");
		a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);

		Optional<Answer> oa = this.answerRepository.findById(1); //답변 조회 테스트
		assertTrue(oa.isPresent());
		Answer b = oa.get();
		assertEquals(2, b.getQuestion().getId());
	}
}
