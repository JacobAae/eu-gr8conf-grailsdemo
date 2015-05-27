<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'attendee.label', default: 'Attendee')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-attendee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	</ul>
</div>
<div id="show-attendee" class="content scaffold-show" role="main">
	<h1><g:message code="default.show.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>


	<ol class="property-list attendee">

		<li class="fieldcontain">
			<span id="name-label" class="property-label">Name</span>
			<span class="property-value" aria-labelledby="name-label">${attendee.name}</span>
		</li>

		<li class="fieldcontain">
			<span id="email-label" class="property-label">Email</span>
			<span class="property-value" aria-labelledby="email-label">${attendee.email}</span>
		</li>

		<li class="fieldcontain">
			<span id="nationality-label" class="property-label">Nationality</span>
			<span class="property-value" aria-labelledby="nationality-label">${attendee.nationality}</span>
		</li>

		<li class="fieldcontain">
			<span id="talks-label" class="property-label">Talks</span>
			<span class="property-value" aria-labelledby="talks-label">
				<ul>
					<g:each in="${attendee.talks}" var="talk">
						<li>${talk.title}</li>
					</g:each>
				</ul>
			</span>
		</li>
	</ol>


</ol>
	<g:form resource="${attendee}" method="DELETE">
		<fieldset class="buttons">
			<g:link class="edit" action="edit" resource="${attendee}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
			<input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
		</fieldset>
	</g:form>
</div>
</body>
</html>