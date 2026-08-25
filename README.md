## MANIFEST
<activity
	android:name=".MainActivity" //Activity inicial, a primeira que abre
	android:exported="true"
	android:windowSoftInputMode="adjustResize" >
	<intent-filter>
		<action android:name="android.intent.action.MAIN" />
		<category android:name="android.intent.category.LAUNCHER" />
	</intent-filter>
</activity>


## Passar a outra tela

variavel_tela : Intent
variavel_tela = Intent(this, TelaQueVou::class.java)
startActivity(variavel_tela)

//ParaFechar
finish()


## Splash - Tela que dura alguns segundos para passar à proxima
//MainActivity Splash - após setContentView:

Handler(Looper.getMainLooper()).postDelayed({
  var telaLogin = Intent(this, LoginActivity::class.java)
  startActivity(telaLogin)
  finish()
},3000)


/********Passar dados entre telas********/

### tela que envia
tela = Intent(this, MainActivity::class.java)
tela.putExtra("usuário", etUsuario.text.toString())
startActivity(tela)

### tela que recebe
//após setContentView

var nomeUsuario = Intent.getStringExtra("usuario")
