#提交git 时候会出现 "push failed: unable to access 'https://github.com/chenshl/py_study_demo.git/': SSL certificate problem: unable to get local issuer certificate"

这个错误并不重要，是系统证书问题，系统判断这个行为会造成不良影响，所以进行了阻止，只需要设置跳过SSL证书验证即可

> 运行git config --global http.sslVerify false