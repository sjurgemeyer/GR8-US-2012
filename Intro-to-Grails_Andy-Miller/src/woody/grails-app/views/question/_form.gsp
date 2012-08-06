<%@ page import="woody.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'answer', 'error')} ">
	<label for="answer">
		<g:message code="question.answer.label" default="Answer" />
		
	</label>
	<g:textField name="answer" value="${questionInstance?.answer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'question', 'error')} ">
	<label for="question">
		<g:message code="question.question.label" default="Question" />
		
	</label>
	<g:textField name="question" value="${questionInstance?.question}"/>
</div>

