<#assign ctx="${(rca.contextPath)!''}">
<#assign bankNo = RequestParameters.bankNo!'218' />
<#assign receiverBankNo = RequestParameters.receiverBankNo!'218' />
<#assign amount = RequestParameters.amount!'0.03' />
<#assign receiverAccountNo = RequestParameters.receiverAccountNo!'300113085110013' />
<#assign receiverAccountName = RequestParameters.receiverAccountName!'测试客户3001130851' />
<#assign receiverIdNo = RequestParameters.receiverIdNo!'620111198506020014' />
<#assign routeCode = RequestParameters.routeCode!'218' />

<form action="#uat/redeem" method="post" id="redeem-form" class="trans-form">
    <h1 class="title">uat赎回</h1>
    bankNo：
    <input type="text" name="bankNo" value="${bankNo}" required/>
    receiverBankNo：
    <input type="text" name="receiverBankNo" value="${receiverBankNo}" required/>
    amount：
    <input type="text" name="amount" value="${amount}"/>
    receiverAccountNo：
    <input type="text" name="receiverAccountNo" value="${receiverAccountNo}" required/>
    receiverAccountName：
    <input type="text" name="receiverAccountName" value="${receiverAccountName}" required/>
    receiverIdNo：
    <input type="text" name="receiverIdNo" value="${receiverIdNo}" required/>
    routeCode：
    <input type="text" name="routeCode" value="${routeCode}" required/>

    <button data-loading-text="正在提交..." class="btn mt-10">提交</button>
</form>


<div class="result">
    <h3>响应结果：</h3>
<#if result??>
    <pre><code>${result?html}</code></pre>
</#if>
</div>

<script>
    window.document.title = $(".title").text() + " | 项目测试";

    $("#redeem-form").submit(function () {
        $btn = $(this).find("button");
        $btn.text($btn.attr("data-loading-text")).attr("disabled", "disabled");
    });
</script>