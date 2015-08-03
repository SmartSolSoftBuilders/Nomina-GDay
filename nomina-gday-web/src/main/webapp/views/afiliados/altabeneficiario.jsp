<form id="formBeneficiario"  name="formBeneficiario" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
	<table border=0>
		<tr>
			<td>		            
			<fieldset> <legend></legend>
			<legend>Nombre</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="nombrebeneficiario" id="nombrebeneficiario" /></label>
			<legend>Apellido Paterno</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="appbeneficiario" id="appbeneficiario" /></label>							
			<legend>Apellido Materno</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="apmbeneficiario" id="apmbeneficiario" /></label>
			<legend>Revocable</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="revocable" id="revocable" /></label>
			<legend>Irrevocable</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="irrevocable" id="irrevocable" /></label>							
			</fieldset>
			</td>
			<td>
			<fieldset>						
			<legend></legend>
			<legend>Parentesco</legend>
				<label>	
					<select name="parentescobeneficiario" id="parentescobeneficiario" class="validate[required]">
						<option value="">Seleccione...</option>
						<option value="PADRE">PADRE</option>
						<option value="MADRE">MADRE</option>
						<option value="HERMANO(A)">HERMANO(A)</option>
						<option value="ABUELO(A)">ABUELO(A)</option>						
						<option value="ESPOSO(A)">ESPOSO(A)</option>
						<option value="HIJO(A)">HIJO(A)</option>
						<option value="NIETO(A)">NIETO(A)</option>
						<option value="TIO(A)">TIO(A)</option>
						<option value="SOBRINO(A)">SOBRINO(A)</option>
						<option value="CONCUBINO(A)">CONCUBINO(A)</option>						
						<option value="OTRO">OTRO</option>						
					</select>
				</label>
			<legend>Porcentaje</legend>
				<label>	
					<select name="parentescobeneficiario" id="parentescobeneficiario" class="validate[required]">
						<option value="">Seleccione...</option>
						<option value="5">5%</option>
						<option value="10">10%</option>
						<option value="20">20%</option>
						<option value="50">50%</option>						
						<option value="100">100%</option>
					</select>
			</label>				
			<legend>Fecha de Nacimiento</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="fechanacimientobeneficiario" id="fechanacimientobeneficiario" /></label>
			<legend>Edad</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="edadbeneficiario" id="edadbeneficiario" /></label>
			</fieldset>
			
			</td>
		</tr>	
		</table>		
</form>		            