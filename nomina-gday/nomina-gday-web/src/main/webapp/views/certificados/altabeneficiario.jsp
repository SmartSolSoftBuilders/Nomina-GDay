<form id="formBeneficiario"  name="formBeneficiario" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
<input type="hidden" id="hidsumaporc" name="hidsumaporc"/>
Suma actual de porcenajes asignados:<div id="divsumaporcentajes"></div>
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
				<label>
					<select name="revocable" id="revocable" class="validate[required]">
						<option value="1">SI</option>
						<option value="0">NO</option>
					</select>					
				
				</label>
			<legend>Irrevocable</legend>
				<label>
					<select name="irrevocable" id="irrevocable" class="validate[required]">
						<option value="1">SI</option>
						<option value="0">NO</option>
					</select>					
				</label>			
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
					<input type="text" name="porcentajebeneficiario" id="porcentajebeneficiario" />					
			</label>
			<legend>Porcentaje gastos funer.:</legend>
				<label>	
					<input type="text" name="porcentajebeneficiario2" id="porcentajebeneficiario2" />					
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